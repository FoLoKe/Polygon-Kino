package polygon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.repos.PreviewRepository;
import polygon.repos.SeatRepository;
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
    private final CityService cityService;
    private final CategoryService categoryService;
    private final BuildingService buildingService;
    private final SessionService sessionService;
    private final PerformanceService performanceService;
    private final RoomService roomService;
    private final PolygonUserDetailsService polygonUserDetailsService;
    private final TransactionService transactionService;

    private final PreviewRepository previewRepository;
    private final SeatRepository seatsRepository;
    private final SeatsRowRepository seatsRowRepository;

    public ManagementController(CityService cityService,
                                CategoryService categoryService,
                                BuildingService buildingService,
                                SessionService sessionService,
                                PerformanceService performanceService,
                                RoomService roomService,
                                PolygonUserDetailsService polygonUserDetailsService,
                                TransactionService transactionService,
                                PreviewRepository previewRepository,
                                SeatRepository seatsRepository,
                                SeatsRowRepository seatsRowRepository) {
        this.cityService = cityService;
        this.categoryService = categoryService;
        this.buildingService = buildingService;
        this.sessionService = sessionService;
        this.performanceService = performanceService;
        this.roomService = roomService;
        this.polygonUserDetailsService = polygonUserDetailsService;
        this.transactionService = transactionService;

        this.previewRepository = previewRepository;
        this.seatsRepository = seatsRepository;
        this.seatsRowRepository = seatsRowRepository;
    }

    @GetMapping(value = "/management/manageCities")
    public ModelAndView manageCities() {
        ModelAndView modelAndView = new ModelAndView("citiesManagement");
        List<City> cities = cityService.allCities();

        modelAndView.addObject("cities", cities);

        return modelAndView;
    }

    @GetMapping(value = "/management/manageCities/delete")
    public ModelAndView deleteCity(@RequestParam("id") int id) {
        if(!cityService.safeDelete(id)) {
            ModelAndView modelAndView = manageCities();
            modelAndView.addObject("error", "Для начала удалите связанные здания");

            return modelAndView;
        }

        return new ModelAndView("redirect:/management/manageCities");
    }

    @GetMapping(value = "/management/manageCities/manage")
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

    @PostMapping(value = "/management/manageCities/save")
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

    @GetMapping(value = "/management/manageCategories")
    public ModelAndView manageCategories() {
        ModelAndView modelAndView = new ModelAndView("categoriesManagement");
        List<Category> categories = categoryService.allCategories();

        modelAndView.addObject("categories", categories);

        return modelAndView;
    }

    @GetMapping(value = "/management/manageCategories/delete")
    public ModelAndView deleteCategory(@RequestParam("id") int id) {
        if(!categoryService.safeDelete(id)) {
            ModelAndView modelAndView = manageCategories();
            modelAndView.addObject("error", "Для начала снимите данную каткгорию с фильмов");

            return modelAndView;
        }

        return new ModelAndView("redirect:/management/manageCategories");
    }

    @GetMapping(value = "/management/manageCategories/manage")
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

    @PostMapping(value = "/management/manageCategories/save")
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

    @GetMapping(value = "/management/manageBuildings")
    public ModelAndView manageBuildings() {
        ModelAndView modelAndView = new ModelAndView("buildingsManagement");
        List<Building> buildings = buildingService.allBuildings();

        modelAndView.addObject("buildings", buildings);

        return modelAndView;
    }

    @GetMapping(value = "/management/manageBuildings/delete")
    public ModelAndView deleteBuilding(@RequestParam("id") int id) {
        if(!buildingService.safeDelete(id)) {
            ModelAndView modelAndView = manageBuildings();
            modelAndView.addObject("error", "Для начала удалите связанные залы");

            return modelAndView;
        }

        return new ModelAndView("redirect:/management/manageBuildings");
    }

    @GetMapping(value = "/management/manageBuildings/manage")
    public ModelAndView manageBuilding(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("buildingManagement");
        String address = "";
        String type = "";
        City defaultCity = null;
        List<City> cities = cityService.allCities();

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

    @PostMapping(value = "/management/manageBuildings/save")
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

    @GetMapping(value = "/management/manageSessions")
    public ModelAndView manageSessions(@RequestParam(required = false, name = "b", defaultValue = "0") int buildingId,
                                       @RequestParam(required = false, name = "t", defaultValue = "0") String stringTime) {
        ModelAndView modelAndView = new ModelAndView("sessionsManagement");
        Map<Performance, List<Session>> sessions = new LinkedHashMap<>();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        List<Building> buildings = buildingService.allBuildings();

        if (buildings.size() > 0) {
            modelAndView.addObject("buildings", buildings);
            Building building = buildings.get(0);

            if(buildingId != 0) {
                Building temp = buildingService.findById(buildingId);
                if(temp != null) {
                    building = temp;
                }
            }

            modelAndView.addObject("defaultBuilding", building);
            Calendar calendar = Calendar.getInstance();

            if(stringTime.equals("0")) {
                calendar.setTime(new Date());
            } else {
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    calendar.setTime(dateFormat.parse(stringTime));
                } catch (Exception e) {
                    e.printStackTrace();
                    calendar.setTime(new Date());
                }
            }

            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            timestamp = new Timestamp(calendar.getTime().getTime());
            sessions = sessionService.findSessionsInBuilding(building, timestamp);
        }

        modelAndView.addObject("sessions", sessions);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        modelAndView.addObject("day", dateFormat.format(timestamp));

        return modelAndView;
    }

    @PostMapping(value = "/management/manageSessions")
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

    @GetMapping(value = "/management/manageSessions/delete")
    public ModelAndView deleteSession(@RequestParam("id") int id) {
        int buildingId = 0;
        String stringTime = "0";

        Session session = sessionService.findById(id);

        if(session != null) {
            buildingId = session.getRoom().getBuilding().getId();
            sessionService.cancel(id);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp timestamp = session.getTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(timestamp);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            stringTime = dateFormat.format(calendar.getTime());
        }

        return new ModelAndView("redirect:/management/manageSessions?b="+buildingId +
                "&t=" + stringTime);
    }

    @GetMapping(value = "/management/manageSessions/manage")
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
            e.printStackTrace();
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

    @PostMapping(value = "/management/manageSessions/save")
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

            Set<Ticket> tickets = new LinkedHashSet<>();

            for (SeatsRow sr : room.getSeatsRows()) {
                for (Seat seat : sr.getSeats()) {
                    if (seat.isSeat()) {
                        Ticket ticket = new Ticket();
                        ticket.setOccupied(false);
                        ticket.setSeat(seat);
                        ticket.setSession(session);
                        tickets.add(ticket);
                    }
                }
            }

            session.setTickets(tickets);

            DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime localDateTime = LocalDateTime.from(sdf.parse(date));

            session.setTime(new Timestamp(Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant()).getTime()));
            sessionService.addSession(session);
        }

        return new ModelAndView("redirect:/management/manageSessions");
    }


    @GetMapping(value = "/management/managePerformances")
    public ModelAndView managePerformances() {
        ModelAndView modelAndView = new ModelAndView("performancesManagement");

        modelAndView.addObject("performances", performanceService.allPerformances());

        return modelAndView;
    }

    @GetMapping(value = "/management/managePerformances/delete")
    public ModelAndView deletePerformance(@RequestParam("id") int id) {
        if(!performanceService.cancel(id)) {
            ModelAndView modelAndView = managePerformances();
            modelAndView.addObject("error", "Для начала завершите связанные сеансы");

            return modelAndView;
        }

        return new ModelAndView("redirect:/management/managePerformances");
    }

    @GetMapping(value = "/management/managePerformances/manage")
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
        modelAndView.addObject("poster", file); // TODO
        modelAndView.addObject("id", id);
        modelAndView.addObject("date", date);
        modelAndView.addObject("cats", categories);

        return modelAndView;
    }

    @PostMapping(value = "/management/managePerformances/save")
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

                    if (file != null && file.getSize() > 0) {
                        performance.setPoster(file.getBytes());
                    }

                    if (files != null && files.length > 0 && files[0].getSize() > 0) {
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
            e.printStackTrace();
        }

        return new ModelAndView("redirect:/management/managePerformances");
    }

    @GetMapping(value = "/management/manageRooms")
    public ModelAndView manageRooms() {
        ModelAndView modelAndView = new ModelAndView("roomsManagement");
        List<Room> rooms = roomService.allRooms();

        modelAndView.addObject("rooms", rooms);

        return modelAndView;
    }

    @GetMapping(value = "/management/manageRooms/delete")
    public ModelAndView deleteRoom(@RequestParam("id") int id) {
        if(!roomService.safeDelete(id)){
            ModelAndView modelAndView = manageRooms();
            modelAndView.addObject("error", "Для начала завершите связанные сеансы");

            return modelAndView;
        }

        return new ModelAndView("redirect:/management/manageRooms");
    }

    @GetMapping(value = "/management/manageRooms/manage")
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

    @PostMapping(value = "/management/manageRooms/save")
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
                int offset = 0;

                for (int iSeat = 1; iSeat <= seatsCount; iSeat++, offset++) {
                    Seat seat = new Seat();
                    seat.setSeat(iSeat - offset);
                    seat.setSeat(false);

                    for (String value : seats) {
                        if (value.equals(iRow + " " + iSeat)) {
                            seat.setSeat(true);
                            offset--;
                        }
                    }

                    seatsRepository.saveAndFlush(seat);
                    seatsSet.add(seat);
                }

                seatsRow.setSeats(seatsSet);
                seatsRow.setRow(iRow);
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

    @GetMapping(value = "/management/manageUsers")
    public ModelAndView manageUsers() {
        ModelAndView modelAndView = new ModelAndView("usersManagement");
        List<User> users = polygonUserDetailsService.allUsers();

        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @GetMapping(value = "/management/manageUsers/delete")
    public ModelAndView deleteUser(@RequestParam("id") int id) {
        polygonUserDetailsService.delete(id);

        return new ModelAndView("redirect:/management/manageUsers");
    }

    @GetMapping(value = "/management/manageUsers/manage")
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
                balance = user.getBalance();
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

    @PostMapping(value = "/management/manageUsers/save")
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

    @GetMapping(value = "/management/manageTransactions")
    public ModelAndView manageTransactions() {
        ModelAndView modelAndView = new ModelAndView("transactionsManagement");
        List<TicketsTransaction> ticketsTransactions = transactionService.allTransactions();

        modelAndView.addObject("transactions", ticketsTransactions);

        return modelAndView;
    }

}
