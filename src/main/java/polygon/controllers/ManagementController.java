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
import polygon.services.interfaces.*;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private SessionService sessionService;

    @Autowired
    private BuildingService buildingService;

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
            Building building = buildingService.getById(Integer.parseInt(id));
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

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageSessions/save", method = RequestMethod.POST)
    public ModelAndView saveSession(@RequestParam(value = "id") int id) {
        sessionService.cancel(id);

        return new ModelAndView("redirect:/management/manageSessions");
    }

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private CategoryService categoryService;

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

        return modelAndView;
    }

    @RequestMapping(value = "/management/manageRooms/save", method = RequestMethod.POST)
    public ModelAndView saveRoom(@ModelAttribute("rowsCount") int rowsCount, @RequestParam("seatsCount") List<Integer> seatsCountList, @RequestParam(value = "seat", required = false) List<String> seats) {

        if(rowsCount > 0 && seats != null) {
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

            room.setNumber(0);
            room.setType("DEBUG");
            roomService.save(room);


        }
        return new ModelAndView("redirect:/management/manageRooms");
    }
}
