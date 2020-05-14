package databasesystems.controller;

import databasesystems.domain.Garbage_carts;
import databasesystems.domain.Graffiti_removal;
import databasesystems.domain.Incident;
import databasesystems.domain.MyUser;
import databasesystems.domain.Pot_holes_reported;
import databasesystems.domain.Query1;
import databasesystems.domain.Query2;
import databasesystems.domain.Query3;
//import databasesystems.domain.Query1;
import databasesystems.domain.Rodent_baiting;
import databasesystems.domain.Sanitation_code_complaints;
import databasesystems.domain.Tree_debris;
import databasesystems.domain.Tree_trims;
import databasesystems.domain.UserQueries;
import databasesystems.domain.UserQueries.UserQPK;
import databasesystems.domain.Vehicles;
import databasesystems.exception.CustomException;
import databasesystems.service.Garbage_cartsService;
import databasesystems.service.Graffiti_removalService;
import databasesystems.service.IncidentService;
import databasesystems.service.PotHolesService;
import databasesystems.service.RodentBaitingService;
import databasesystems.service.SanitationService;
import databasesystems.service.TreeTrimsService;
import databasesystems.service.Tree_debrisService;
import databasesystems.service.UserQuerySService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import databasesystems.service.UserService;
import databasesystems.service.VehiclesService;
import io.jsonwebtoken.JwtBuilder;
import static java.awt.SystemColor.window;
//import databasesystems.service.q1Service;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javassist.CtMethod.ConstParameter.string;
import javax.sql.DataSource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import static org.springframework.data.repository.init.ResourceReader.Type.JSON;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.springframework.security.crypto.keygen.KeyGenerators.string;

@Controller
@RestController
@RequestMapping("/")
class UserController {

    private String jwtreturned;
    
    @Autowired
    UserService userService;

    @Autowired
    IncidentService incService;
    
    @Autowired
    VehiclesService vehService;
    
    @Autowired
    Graffiti_removalService grService;
    
    @Autowired
    Garbage_cartsService gcService;
    
    @Autowired
    UserQuerySService uqService;
    
    @Autowired
    PotHolesService phService;
    
    @Autowired
    RodentBaitingService rbService;
    
    @Autowired
    SanitationService sanService;
     
    @Autowired
    Tree_debrisService tdService;
   
    @Autowired
    TreeTrimsService ttService;
    
    @Autowired
    DataSource dataSource;
    
    /*
    @Autowired
    q1Service Q1Service;
    */    
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    
    @GetMapping
    ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("user");
        System.out.println("home JWT !!!!! "+jwtreturned);
        //modelAndView.addObject("/signup");
        return modelAndView;
    }
    
    @GetMapping(value="/search")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView sear() {
        ModelAndView modelAndView = new ModelAndView("search");
        System.out.println("JWT !!!!! "+jwtreturned);
        //modelAndView.addObject("/signup");
        return modelAndView;
    }
    
    @GetMapping(value="/ins")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView inshome() {
        ModelAndView modelAndView = new ModelAndView("insert");
        System.out.println("JWT !!!!! "+jwtreturned);
        //modelAndView.addObject("/signup");
        return modelAndView;
    }
    
    
   
    @PostMapping(value="/sear1")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView sear1(@RequestParam String start1,@RequestParam String end1,HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView("search1");
        System.out.println("JWT !!!!! "+jwtreturned);
        try {
            Connection conn=dataSource.getConnection();
            System.out.println("got connection!!!!!!");
            //Date start=new SimpleDateFormat("dd-mm-yyyy").parse("1-1-2018");
            //Date end=new SimpleDateFormat("dd-mm-yyyy").parse("31-12-2018");
            PreparedStatement proc = conn.prepareStatement("select * from query01(?,?)");
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            //java.util.Date sdate = sdf1.parse("1-1-2018");
            java.util.Date sdate = sdf1.parse(start1);
            java.sql.Date sqlStartDate = new java.sql.Date(sdate.getTime());  
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
            //java.util.Date edate = sdf2.parse("31-12-2018");
            java.util.Date edate = sdf2.parse(end1);
            java.sql.Date sqlEndDate = new java.sql.Date(edate.getTime());  
            proc.setDate(1, sqlStartDate );
            proc.setDate(2, sqlEndDate);
            ResultSet results = proc.executeQuery();
            List<Query1> resSet = new ArrayList<>();
            while (results.next())
            {
                Query1 q1=new Query1();
                q1.setCounter(results.getInt(1));
                q1.setType(results.getString(2));
                resSet.add(q1);
                System.out.println(q1.getCounter()+" "+q1.getType());
            }
            results.close();
            proc.close();
            modelAndView.addObject("results1",resSet) ;
            User user = (User)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            String username=user.getUsername();
            UserQueries newUQ=new UserQueries();
            UserQPK newUQPK=new UserQPK();
            newUQPK.setDate_time(new Date());
            newUQPK.setQuery_id(1);
            newUQPK.setUser_id(username);
            newUQ.setId(newUQPK);
            uqService.addUserQuery(newUQ);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelAndView;
    }
   
@PostMapping(value="/sear2")
@ResponseStatus(value = HttpStatus.OK)
ModelAndView sear2(@RequestParam String type2, @RequestParam String start2,@RequestParam String end2) {
    ModelAndView modelAndView = new ModelAndView("search2");
    System.out.println("JWT !!!!! "+jwtreturned);
    try {
        Connection conn=dataSource.getConnection();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! "+type2);
        //Date start=new SimpleDateFormat("dd-mm-yyyy").parse("1-1-2018");
        //Date end=new SimpleDateFormat("dd-mm-yyyy").parse("31-12-2018");
        PreparedStatement proc = conn.prepareStatement("select * from query02(?,?,?)");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        //java.util.Date sdate = sdf1.parse("1-1-2018");
        java.util.Date sdate = sdf1.parse(start2);
        java.sql.Date sqlStartDate = new java.sql.Date(sdate.getTime());  
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
        //java.util.Date edate = sdf2.parse("31-12-2018");
        java.util.Date edate = sdf2.parse(end2);
        java.sql.Date sqlEndDate = new java.sql.Date(edate.getTime());  
        proc.setString(1,type2);
        proc.setDate(2, sqlStartDate );
        proc.setDate(3, sqlEndDate);
        ResultSet results = proc.executeQuery();
        List<Query2> resSet = new ArrayList<>();
        while (results.next())
        {
            Query2 q2=new Query2();
            q2.setCounter(results.getInt(1));
            q2.setDate(results.getDate(2));
            resSet.add(q2);
        }
        results.close();
        proc.close();
        modelAndView.addObject("results2",resSet) ;
        User user = (User)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        String username=user.getUsername();
        UserQueries newUQ=new UserQueries();
        UserQPK newUQPK=new UserQPK();
        newUQPK.setDate_time(new Date());
        newUQPK.setQuery_id(2);
        newUQPK.setUser_id(username);
        newUQ.setId(newUQPK);
        uqService.addUserQuery(newUQ);
    } catch (SQLException ex) {
        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
    }
    return modelAndView;
}

@PostMapping(value="/sear3")
@ResponseStatus(value = HttpStatus.OK)
ModelAndView sear3(@RequestParam String day3) {
    ModelAndView modelAndView = new ModelAndView("search3");
    try {
        System.out.println("JWT !!!!! "+jwtreturned);
        Connection conn=dataSource.getConnection();
        //Date start=new SimpleDateFormat("dd-mm-yyyy").parse("1-1-2018");
        //Date end=new SimpleDateFormat("dd-mm-yyyy").parse("31-12-2018");
        PreparedStatement proc = conn.prepareStatement("select * from query03(?)");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        //java.util.Date sdate = sdf1.parse("1-1-2018");
        java.util.Date sdate = sdf1.parse(day3);
        java.sql.Date sqlStartDate = new java.sql.Date(sdate.getTime());  
        //java.util.Date edate = sdf2.parse("31-12-2018");
        proc.setDate(1, sqlStartDate );
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
        ResultSet results = proc.executeQuery();
        System.out.println("llllllllllllllllllll");
        List<Query3> resSet = new ArrayList<>();
        while (results.next())
        {
            Query3 q2=new Query3();
            q2.setType(results.getString(1));
            q2.setZipCode(results.getInt(2));
            resSet.add(q2);
            System.out.println(q2.getType()+" "+q2.getZipCode());
        }
        results.close();
        proc.close();
        modelAndView.addObject("results3",resSet) ;
        User user = (User)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        String username=user.getUsername();
        UserQueries newUQ=new UserQueries();
        UserQPK newUQPK=new UserQPK();
        newUQPK.setDate_time(new Date());
        newUQPK.setQuery_id(3);
        newUQPK.setUser_id(username);
        newUQ.setId(newUQPK);
        uqService.addUserQuery(newUQ);
    } catch (SQLException ex) {
        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
    }
    return modelAndView;
}
    
    @PostMapping(value="/insert")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView insert(//
            @RequestParam String street,@RequestParam String zip,
            @RequestParam String itype,@RequestParam String x,
            @RequestParam String y,@RequestParam String ward,
            @RequestParam String police,@RequestParam String community,
            @RequestParam String ssa,@RequestParam String lat,@RequestParam String lon,
            @RequestParam String lp,@RequestParam String mm,
            @RequestParam String days,@RequestParam String col,
            @RequestParam String surface,@RequestParam String bcd,@RequestParam String nature,
            @RequestParam String phnumber,@RequestParam String grlocation,
            @RequestParam String debrisloc,@RequestParam String treetrims,
            @RequestParam String numberpb,@RequestParam String numberwg,@RequestParam String numberwr
                    
    ){
                ModelAndView modelAndView = new ModelAndView("insert");

                Incident newIncident=new Incident();
                newIncident.setCommunity_area(Integer.parseInt(community));
                newIncident.setPolice_district(Integer.parseInt(police));
                newIncident.setWard(Integer.parseInt(ward));
                newIncident.setSsa(Integer.parseInt(ssa));
                newIncident.setZip_code(Integer.parseInt(zip));
                                
                newIncident.setType_of_service_requested(itype);
                newIncident.setStreet_address(street);
                
                newIncident.setX_coord(new BigDecimal(x));
                newIncident.setY_coord(new BigDecimal(y));
                newIncident.setLatitude(new BigDecimal(lat));
                newIncident.setLongitude(new BigDecimal(lon));
                
                newIncident.setCreation_date(new Date());
                newIncident.setStatus("Open");
                
                
                newIncident = incService.addIncident(newIncident);
                if(itype.equals("Abandoned Vehicle Complaint")){
                    Vehicles newVeh = new Vehicles();
                    newVeh.setId(newIncident.getId());
                    newVeh.setHow_many_days_is_the_vehicle_parked(Integer.parseInt(days));
                    newVeh.setLicense_plate(lp);
                    newVeh.setVehicle_color(col);
                    newVeh.setVehicle_mademodel(mm);
                    newVeh=vehService.addVehicle(newVeh);
                }
                else if (itype.equals("Rodent Baiting/Rat Complaint")){
                    Rodent_baiting newVeh = new Rodent_baiting();
                    newVeh.setId(newIncident.getId());
                    newVeh.setNumber_of_premises_baited(Integer.parseInt(numberpb));
                    newVeh.setNumber_of_premises_with_garbage(Integer.parseInt(numberwg));
                    newVeh.setNumber_of_premises_with_rodent(Integer.parseInt(numberwr));
                    newVeh=rbService.addIncident(newVeh);
                }
                else if (itype.equals("Garbage Cart Black Maintenance/Replacement")){
                    Garbage_carts newVeh = new Garbage_carts();
                    newVeh.setId((int) newIncident.getId());
                    newVeh.setNumber_of_black_carts_delivered(Integer.parseInt(bcd));
                    newVeh=gcService.addGarbage_carts(newVeh);
                }
                else if (itype.equals("Sanitation Code Violation")){
                    Sanitation_code_complaints newVeh = new Sanitation_code_complaints();
                    newVeh.setId((int) newIncident.getId());
                    newVeh.setWhat_is_the_nature_of_this_code_violations(nature);
                    newVeh=sanService.addIncident(newVeh);
                }
                else if (itype.equals("Pot Hole in Street")){
                    Pot_holes_reported newVeh = new Pot_holes_reported();
                    newVeh.setId(newIncident.getId());
                    newVeh.setNumber_of_potholes_filled_on_block(Integer.parseInt(phnumber));
                    newVeh=phService.addIncident(newVeh);
                }
                else if (itype.equals("Graffiti Removal")){
                    Graffiti_removal newVeh = new Graffiti_removal();
                    newVeh.setId((int) newIncident.getId());
                    newVeh.setWhat_type_of_surface_is_the_graffiti_on(surface);
                    newVeh.setWhere_is_the_graffiti_located(grlocation);
                    newVeh=grService.addGraffiti(newVeh);
                }
                else if (itype.equals("Tree Debris")){
                    Tree_debris newVeh = new Tree_debris();
                    newVeh.setId((int) newIncident.getId());
                    newVeh.setIf_yes_where_is_the_debris_located(debrisloc);
                    newVeh=tdService.addTree_debris(newVeh);
                }
                else if (itype.equals("Tree Trim")){
                    Tree_trims newVeh = new Tree_trims();
                    newVeh.setId((int) newIncident.getId());
                    newVeh.setLocation_of_trees(treetrims);
                    newVeh=ttService.addIncident(newVeh);
                }
                return modelAndView;
        }    
            
    @PostMapping(value="/signin")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView login(//
        @RequestParam String uname, //
        @RequestParam String pass,
        HttpServletResponse response) {
            ModelAndView modelAndView = new ModelAndView("insert");
            try{

        //try{  
                System.out.println("lllllllllllllllllllllllll");
                jwtreturned=userService.signin(uname, pass);
        //} 
                Cookie jwtCookie = new Cookie("jwtCookie",jwtreturned);
                jwtCookie.setPath("/");
                jwtCookie.setMaxAge(20000*600000);
                //Cookie cannot be accessed via JavaScript
                jwtCookie.setHttpOnly(true);
                response.addCookie(jwtCookie);
//                response.addHeader("Authorization", "Bearer "+jwtreturned);
//                System.out.println("QQQQQQQQQQQQQQQQ "+response.getHeader("Authorization"));
            }
            catch (Exception e){
                throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return modelAndView;
        }
    
    @PostMapping(value = "/signup")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView addUser(@RequestParam String uname,
        @RequestParam String name,
        @RequestParam String address,
        @RequestParam String email,
        @RequestParam String pass,
        @RequestParam String rpass) throws Exception {
            ModelAndView modelAndView = new ModelAndView("user");
            try {
                if(!pass.equals(rpass))
                    throw new IllegalArgumentException("Passwords not match");
                if(userService.getUser(uname)!=null)
                    throw new IllegalArgumentException("Username used");
                System.out.println("COntinue!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                MyUser user = new MyUser();
                user.setUsername(uname);
                user.setName(name);
                user.setAddress(address);
                user.setEmail(email);
                user.setPassword(bCryptPasswordEncoder.encode(pass));
                user = userService.addUser(user);
                modelAndView.addObject("message", "User added with name: " + user.getName());
            }
            catch (Exception ex){
                throw new CustomException("Failed to add user: " + ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
                //modelAndView.addObject("message", );
            }
            modelAndView.addObject("users", userService.getUsers());
            return modelAndView;
    }

    /*
    @GetMapping("/users/{uname}")
    public ModelAndView show(@PathVariable Integer studentId) {
      ModelAndView modelAndView = new ModelAndView("course");
      modelAndView.addObject("student", studentService.getStudent(studentId));
      return modelAndView;
    }

    @PostMapping("/students/{studentId}/courses")
    @ResponseStatus(value = HttpStatus.OK)
    ModelAndView addCourse(@PathVariable Integer studentId,
                            @RequestParam String name,
                            @RequestParam String grade ) throws Exception {

        ModelAndView modelAndView = new ModelAndView("course");
        Student student = studentService.getStudent(studentId);
        try {
          Course course = new Course();
          course.setStudent(student);
          course.setName(name);
          course.setGrade(Integer.parseInt(grade));
          student.getCourses().add(course);
          student = studentService.addStudent(student);
          modelAndView.addObject("message", "Course added with name: " + course.getName());
        }
        catch (Exception ex){
          modelAndView.addObject("message", "Failed to add course: " + ex.getMessage());
        }
        modelAndView.addObject("student", student);
        return modelAndView;
    }
*/
}
