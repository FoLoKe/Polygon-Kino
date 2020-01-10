package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.repos.PreviewRepository;
import polygon.repos.SeatsRepository;
import polygon.repos.SeatsRowRepository;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.*;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class ManagementController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/management/manageCities", method = RequestMethod.GET)
    public ModelAndView mangeCities() {
        ModelAndView modelAndView = new ModelAndView("citiesManagement");
        List<City> cities = cityService.allCities();
        modelAndView.addObject("cities", cities);

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageCities/delete", method = RequestMethod.GET)
    public ModelAndView deleteCity(@RequestParam("id") int id) {
        cityService.safeDelete(id);

        return new ModelAndView("redirect:/management/manageCities");
    }

    @RequestMapping(value = "/management/manageCities/manage", method = RequestMethod.GET)
    public ModelAndView manageCity(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("cityManagement");

        String name = "";
        if(id != 0) {
            City city = cityService.findById(id);
            if (city != null) {
                name = city.getName();
            }
        }

        modelAndView.addObject("name", name);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping(value = "/management/manageCities/save", method = RequestMethod.POST)
    public ModelAndView saveCity(@ModelAttribute("id") int id,
                                 @ModelAttribute("name") String name) {
        if (name != null && name.length() > 0) {
            if (id != 0) {
                City city = cityService.findById(id);
                if (city != null) {
                    city.setName(name);
                    cityService.save(city);
                }
            } else {
                City city = new City();
                city.setName(name);
                cityService.save(city);
            }
        }
        return new ModelAndView("redirect:/management/manageCities");
    }

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/management/manageCategories", method = RequestMethod.GET)
    public ModelAndView mangeCategories() {
        ModelAndView modelAndView = new ModelAndView("categoriesManagement");
        List<Category> categories = categoryService.allCategories();
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageCategories/delete", method = RequestMethod.GET)
    public ModelAndView deleteCategory(@RequestParam("id") int id) {
        categoryService.safeDelete(id);

        return new ModelAndView("redirect:/management/manageCategories");
    }

    @RequestMapping(value = "/management/manageCategories/manage", method = RequestMethod.GET)
    public ModelAndView manageCategory(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("categoryManagement");

        String name = "";
        if(id != 0) {
            Category category = categoryService.findById(id);
            if (category != null) {
                name = category.getName();
            }
        }

        modelAndView.addObject("name", name);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping(value = "/management/manageCategories/save", method = RequestMethod.POST)
    public ModelAndView saveCategory(@ModelAttribute("id") int id,
                                 @ModelAttribute("name") String name) {
        if (name != null && name.length() > 0) {
            Category category = new Category();
            if (id != 0) {
                category = categoryService.findById(id);
            }

            if (category != null) {
                category.setName(name);
                categoryService.save(category);
            }

        }
        return new ModelAndView("redirect:/management/manageCategories");
    }

    @RequestMapping(value = "/management/manageBuildings", method = RequestMethod.GET)
    public ModelAndView manageBuildings() {
        ModelAndView modelAndView = new ModelAndView("buildingsManagement");
        List<Building> buildings = buildingService.allBuildings();
        modelAndView.addObject("buildings", buildings);

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageBuildings/delete", method = RequestMethod.GET)
    public ModelAndView deleteBuilding(@RequestParam("id") int id) {
        buildingService.safeDelete(id);

        return new ModelAndView("redirect:/management/manageBuildings");
    }

    @RequestMapping(value = "/management/manageBuildings/manage", method = RequestMethod.GET)
    public ModelAndView manageBuilding(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("buildingManagement");

        String address = "";
        String type = "";
        List<City> cities = cityService.allCities();
        City defaultCity = null;
        if(cities.size() > 0) {
            defaultCity = cities.get(0);
        }
        if(id != 0) {
            Building building = buildingService.findById(id);
            if (building != null) {
                address = building.getAddress();
                type = building.getType();
                defaultCity = building.getCity();
            }
        }

        modelAndView.addObject("address", address);
        modelAndView.addObject("id", id);
        modelAndView.addObject("type", type);
        modelAndView.addObject("cities", cities);
        modelAndView.addObject("defaultCity", defaultCity);
        return modelAndView;
    }

    @RequestMapping(value = "/management/manageBuildings/save", method = RequestMethod.POST)
    public ModelAndView manageBuilding(@ModelAttribute("id") int id,
                                     @ModelAttribute("address") String address,
                                       @ModelAttribute("type") String type,
                                       @ModelAttribute("selectedCity") int cityId)
    {
        City city = cityService.findById(cityId);
        if (address != null && address.length() > 0 && type.length() > 0 && city != null) {
            Building building = new Building();
            if (id != 0) {
                building = buildingService.findById(id);
            }

            if (building != null) {
                building.setAddress(address);
                building.setCity(city);
                building.setType(type);
                buildingService.save(building);
            }

        }
        return new ModelAndView("redirect:/management/manageBuildings");
    }

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/management/manageSessions", method = RequestMethod.GET)
    public ModelAndView mangeSessions() {
        ModelAndView modelAndView = new ModelAndView("sessionsManagement");
        List<Building> buildings = buildingService.allBuildings();
        Map<Performance, List<Session>> sessions = new LinkedHashMap<>();

        if (buildings.size() > 0) {
            modelAndView.addObject("buildings", buildings);
            Building building = buildings.get(0);
            modelAndView.addObject("defaultBuilding", building);
            sessions = sessionService.findSessionsInBuilding(building, new Timestamp(new Date().getTime()));
        }

        modelAndView.addObject("sessions", sessions);

        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());
        modelAndView.addObject("day", dateFormat.format(date));

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageSessions", method = RequestMethod.POST)
    public ModelAndView manageSessionByDay(@ModelAttribute("day") String date,
                                           @ModelAttribute("selectedBuilding") String id) {
        ModelAndView modelAndView = new ModelAndView("sessionsManagement");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date utilDate = new Date();
        try {
            utilDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
        modelAndView.addObject("day", date);

        Map<Performance, List<Session>> sessions = new LinkedHashMap<>();
        List<Building> buildings = buildingService.allBuildings();


        if (buildings != null) {
            modelAndView.addObject("buildings", buildings);
            Building building = buildingService.findById(Integer.parseInt(id));
            modelAndView.addObject("defaultBuilding", building);
            sessions = sessionService.findSessionsInBuilding(building, time);
        }

        modelAndView.addObject("sessions", sessions);

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageSessions/delete", method = RequestMethod.GET)
    public ModelAndView deleteSession(@RequestParam("id") int id) {
        sessionService.cancel(id);

        return new ModelAndView("redirect:/management/manageSessions");
    }

    @RequestMapping(value = "/management/manageSessions/manage", method = RequestMethod.GET)
    public ModelAndView manageSession(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("sessionManagement");

        Performance defaultPerformance = null;
        List<Performance> performances = performanceService.allPerformances();
        if(performances.size() > 0) {
            defaultPerformance = performances.get(0);
        }

        Room defaultRoom = null;
        List<Room> rooms = roomService.allRooms();
        if(rooms.size() > 0) {
            defaultRoom = rooms.get(0);
        }

        LocalDateTime date = LocalDateTime.now();
        float price = 0;

        if (id != 0) {
            Session session = sessionService.findById(id);
            if (session != null) {

                date = session.getTime().toLocalDateTime();
                price = session.getPrice();
            }
        }

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String sDate = "";
        try {
            sDate = date.format(sdf);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        modelAndView.addObject("performances", performances);
        modelAndView.addObject("defaultPerformance", defaultPerformance);
        modelAndView.addObject("rooms", rooms);
        modelAndView.addObject("defaultRoom", defaultRoom);

        modelAndView.addObject("date", sDate);
        modelAndView.addObject("price", price);
        modelAndView.addObject("id", id);

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageSessions/save", method = RequestMethod.POST)
    public ModelAndView saveSession(@RequestParam(value = "id") int id,
                                    @ModelAttribute("price") float price,
                                    @ModelAttribute("selectedRoom") int selectedRoom,
                                    @ModelAttribute("selectedPerformance") int selectedPerformance,
                                    @ModelAttribute("date") String date)
    {
        Room room = roomService.findById(selectedRoom);
        Performance performance = performanceService.findById(selectedPerformance);
        if(price > 0 && room != null && performance != null) {
            Session session = sessionService.findById(id);
            if (session == null) {
                session = new Session();
            }

            session.setRoom(room);
            session.setPerformance(performance);
            session.setPrice(price);

            DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime localDateTime = LocalDateTime.from(sdf.parse(date));

            session.setTime(new Timestamp(Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant()).getTime()));
            sessionService.addSession(session);
        }
        return new ModelAndView("redirect:/management/manageSessions");
    }

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private PreviewRepository previewRepository;

    @RequestMapping(value = "/management/managePerformances", method = RequestMethod.GET)
    public ModelAndView managePerformances() {
        ModelAndView modelAndView = new ModelAndView("performancesManagement");

        modelAndView.addObject("performances", performanceService.allPerformances());

        return modelAndView;
    }

    @RequestMapping(value = "/management/managePerformances/delete", method = RequestMethod.GET)
    public ModelAndView deletePerformance(@RequestParam("id") int id) {
        performanceService.cancel(id);

        return new ModelAndView("redirect:/management/managePerformances");
    }

    @RequestMapping(value = "/management/managePerformances/manage", method = RequestMethod.GET)
    public ModelAndView managePerformance(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("performanceManagement");
        String name = "";
        String link = "";
        String imdb = "";
        String description = "";
        File file = null;
        Date date = new Date();
        Map<Category, Boolean> categories = new LinkedHashMap<>();
        if(id != 0) {
            Performance performance = performanceService.findById(id);
            if (performance != null) {
                name = performance.getName();
                link = performance.getTrailerLink();
                imdb = performance.getImdbRating();
                description = performance.getDescription();
                date = performance.getDate();
                Set<Category> categorySet = performance.getCategories();

                for (Category cat : categoryService.allCategories()) {
                    categories.put(cat, false);
                    for (Category selected : categorySet) {
                        if (selected.getId() == cat.getId()) {
                            categories.replace(cat, true);
                            break;
                        }
                    }
                }
            }
        }

        modelAndView.addObject("name", name);
        modelAndView.addObject("link", link);
        modelAndView.addObject("imdbID", imdb);
        modelAndView.addObject("description", description);
        modelAndView.addObject("poster", file);
        modelAndView.addObject("id", id);
        modelAndView.addObject("date", date);
        modelAndView.addObject("cats", categories);
        return modelAndView;
    }

    @RequestMapping(value = "/management/managePerformances/save", method = RequestMethod.POST)
    public ModelAndView savePerformance(@ModelAttribute(value = "id") int id,
                                        @ModelAttribute("name") String name,
                                        @ModelAttribute("link") String link,
                                        @ModelAttribute("imdb") String imdb,
                                        @ModelAttribute("description") String description,
                                        @ModelAttribute("file") MultipartFile file,
                                        @ModelAttribute("files") MultipartFile[] files,
                                        @ModelAttribute("date") String date,
                                        @RequestParam(value = "cats", required = false) List<String> cats)
    {
        try {
            if (name != null && name.length() > 0) {
                if (id != 0) {
                    Performance performance = performanceService.findById(id);
                    if (performance == null) {
                        performance = new Performance();
                    }
                    performance.setName(name);
                    performance.setTrailerLink(link);
                    performance.setImdbRating(imdb);
                    performance.setDescription(description);

                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date utilDate = new Date();
                    try {
                        utilDate = dateFormat.parse(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    performance.setDate(new java.sql.Date(utilDate.getTime()));
                    if (file != null) {
                        performance.setPoster(file.getBytes());
                    }
                    if (files != null && files.length > 0) {
                        Set<Preview> previews = new HashSet<>();
                        for (MultipartFile pf : files) {
                            Preview preview = new Preview();
                            preview.setImage(pf.getBytes());
                            previews.add(preview);
                        }
                        performance.setPreviews(previews);
                        previewRepository.saveAll(previews);
                    }
                    Set<Category> categories = new HashSet<>();
                    if(cats != null) {
                        for (String s: cats) {
                            int catId = Integer.parseInt(s);
                            categories.add(categoryService.findById(catId));
                        }
                    }
                    performance.setCategories(categories);
                    performanceService.save(performance);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new ModelAndView("redirect:/management/managePerformances");
    }

    @Autowired
    private RoomService roomService;

    @Autowired
    SeatsRepository seatsRepository;

    @Autowired
    SeatsRowRepository seatsRowRepository;

    @RequestMapping(value = "/management/manageRooms", method = RequestMethod.GET)
    public ModelAndView mangeRooms() {
        ModelAndView modelAndView = new ModelAndView("roomsManagement");
        List<Room> rooms = roomService.allRooms();
        modelAndView.addObject("rooms", rooms);

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageRooms/delete", method = RequestMethod.GET)
    public ModelAndView deleteRoom(@RequestParam("id") int id) {
        roomService.safeDelete(id);

        return new ModelAndView("redirect:/management/manageRooms");
    }

    @RequestMapping(value = "/management/manageRooms/manage", method = RequestMethod.GET)
    public ModelAndView manageRoom() {
        ModelAndView modelAndView = new ModelAndView("roomManagement");
        Building defaultBuilding = null;
        List<Building> buildings = buildingService.allBuildings();
        if(buildings.size() > 0) {
            defaultBuilding = buildings.get(0);
        }

        modelAndView.addObject("defaultBuilding", defaultBuilding);
        modelAndView.addObject("buildings", buildings);
        return modelAndView;
    }

    @RequestMapping(value = "/management/manageRooms/save", method = RequestMethod.POST)
    public ModelAndView saveRoom(@ModelAttribute("rowsCount") int rowsCount,
                                 @ModelAttribute("selectedBuilding") int buildingId,
                                 @ModelAttribute("number") int number,
                                 @ModelAttribute("type") String type,
                                 @RequestParam("seatsCount") List<Integer> seatsCountList,
                                 @RequestParam(value = "seat", required = false) List<String> seats)
    {
        Building building = buildingService.findById(buildingId);
        if(rowsCount > 0 && seats != null && building != null && number > 0 && type.length() > 0) {
            Room room = new Room();
            Set<SeatsRow> seatsRowSet = new LinkedHashSet<>();
            for (int iRow = 1; iRow <= rowsCount; iRow++) {
                SeatsRow seatsRow = new SeatsRow();
                Set<Seat> seatsSet = new LinkedHashSet<>();
                int seatsCount = seatsCountList.get(iRow - 1);
                for (int iSeat = 1; iSeat <= seatsCount; iSeat++) {
                    Seat seat = new Seat();
                    seat.setSeat(iSeat);
                    seat.setSeat(false);
                    for (String value : seats) {
                        if (value.equals(iRow + " " + iSeat)) {
                            seat.setSeat(true);
                        }
                    }

                    seatsRepository.saveAndFlush(seat);
                    seatsSet.add(seat);
                }


                seatsRow.setSeats(seatsSet);
                seatsRowRepository.saveAndFlush(seatsRow);
                seatsRowSet.add(seatsRow);
            }

            room.setSeatsRows(seatsRowSet);

            room.setBuilding(building);
            room.setNumber(number);
            room.setType(type);
            roomService.save(room);


        }
        return new ModelAndView("redirect:/management/manageRooms");
    }

    @Autowired
    private PolygonUserDetailsService polygonUserDetailsService;

    @RequestMapping(value = "/management/manageUsers", method = RequestMethod.GET)
    public ModelAndView mangeUsers() {
        ModelAndView modelAndView = new ModelAndView("usersManagement");
        List<User> users = polygonUserDetailsService.allUsers();
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageUsers/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam("id") int id) {
        polygonUserDetailsService.delete(id);

        return new ModelAndView("redirect:/management/manageUsers");
    }

    @RequestMapping(value = "/management/manageUsers/manage", method = RequestMethod.GET)
    public ModelAndView manageUser(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("userManagement");

        String username = "";
        String email = "";
        String password = "";
        String role = "";
        int balance = 0;
        if(id != 0) {
            User user = polygonUserDetailsService.findById(id);
            if (user != null) {
                username = user.getUsername();
                email = user.getEmail();
                password = user.getPassword();
                role = user.getRole();
            }
        }

        modelAndView.addObject("username", username);
        modelAndView.addObject("email", email);
        modelAndView.addObject("id", id);
        modelAndView.addObject("password", password);
        modelAndView.addObject("role", role);
        modelAndView.addObject("balance", balance);
        return modelAndView;
    }

    @RequestMapping(value = "/management/manageUsers/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("id") int id,
                                 @ModelAttribute("username") String username,
                                 @ModelAttribute("email") String email,
                                 @ModelAttribute("password") String password,
                                 @ModelAttribute("balance") int balance,
                                 @ModelAttribute("role") String role) {
        if ( username.length() > 0 && email.length() > 0 && password.length() > 0 && balance >= 0 && role.length() > 0) {
            User user = new User();
            if (id != 0) {
                user = polygonUserDetailsService.findById(id);
            }

            if (user != null) {
                user.setUsername(username);
                user.setEmail(email);
                user.setBalance(balance);
                user.setRole(role);
                user.setPassword(password);
                polygonUserDetailsService.save(user);
            }

        }
        return new ModelAndView("redirect:/management/manageUsers");
    }


    @Autowired
    TransactionService transactionService;
    @RequestMapping(value = "/management/manageTransactions", method = RequestMethod.GET)
    public ModelAndView mangeTransactions() {
        ModelAndView modelAndView = new ModelAndView("transactionsManagement");
        List<TicketsTransaction> ticketsTransactions = transactionService.allTransactions();
        modelAndView.addObject("transactions", ticketsTransactions);

        return modelAndView;
    }

}
