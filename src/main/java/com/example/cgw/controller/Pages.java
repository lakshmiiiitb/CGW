package com.example.cgw.controller;

import com.example.cgw.JPAData.Customer;
import com.example.cgw.JPAData.Delivery;
import com.example.cgw.JPAData.Login;
import com.example.cgw.JPAData.Partner;
import com.example.cgw.dao.CustomerRepo;
import com.example.cgw.dao.DeliveryRepo;
import com.example.cgw.dao.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
public class Pages {

    /*public static String type=new String();

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    CustomerRepo cust;

    @Autowired
    DeliveryRepo del;

    @Autowired
    PartnerRepo part;


    @PostMapping(path = "/login")
    public Object login(@RequestBody Login login)
    {
        String type=login.getType();
        String username=login.getUsername();
        String password=login.getPassword();
        System.out.println(type+"  "+username+"  "+password);
        System.out.println("Entered login");
        if(type.equals("cust"))
        {
            //check cust table
            //on successful login, return respective dashboards
            Customer account=cust.findByUsername(username);
            if(account == null)
                return null;
            //System.out.println(account.size());
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getName());
                return account;
            }
            else
                return null;

        }
        else if(type.equals("del"))
        {
            //check cust table
            Delivery account=del.findByUsername(username);
            if(account == null)
                return null;
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getName());
                return account;
            }
            else
                return null;

        }
        else if(type.equals("part"))
        {
            //check cust table
            Partner account=part.findByUsername(username);
            if(account == null)
                return null;
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getStoreName());
                return account;
            }
            else
                return null;

        }
        //verify credentials
        return null;
    }

    @PostMapping(path = "/partner")
    public Partner partner(Partner p)
    {
        //register
        //accept partner input, save it in db
        //System.out.println(p);
        //Partner p=new Partner(storeName,storeLoc,username,password,contactno,email);
        System.out.println(p);
        return  myUserDetailsService.PartnerRegister(p);
        //present him home page, so he can login
    }
    @PostMapping(path="/customer")
    public ResponseEntity customer(@RequestBody Customer c)
    {
        //register
        //accept customer input, save it in db
        //c.setPassword(bCryptPasswordEncoder.encode(c.getPassword()));
        /*cust.save(c);
        System.out.println("cust reg");
        return c;//present him home page, so he can login
        System.out.println(c);
        return ResponseEntity.ok(myUserDetailsService.CustomerRegister(c));
    }
    @PostMapping(path="/delivery")
    public ResponseEntity delivery(@RequestBody Delivery d)
    {
        //register
        //accept delivery input, save it in db
        /*del.save(d);
        System.out.println("Del reg");
        return d;//present him home page, so he can login
        System.out.println(d);
        return ResponseEntity.ok(myUserDetailsService.DeliveryRegister(d));
    }


    @PostMapping(value = "/auth")
    public ResponseEntity createAuthenticationToken(@RequestBody Login login) throws Exception
    {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
            );
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("Incorect username and password" , e);
        }
        type=login.getType();
        final UserDetails userDetails= myUserDetailsService.loadUserByUsername(login.getUsername());
        final String jwt= jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }*/
    @Autowired
    CustomerRepo cust;

    @Autowired
    DeliveryRepo del;

    @Autowired
    PartnerRepo part;


    @PostMapping(path = "/login")
    public Object login(@RequestBody Login login)
    {
        String type=login.getType();
        String username=login.getUsername();
        String password=login.getPassword();
        System.out.println(type+"  "+username+"  "+password);
        System.out.println("Entered login");
        if(type.equals("cust"))
        {
            //check cust table
            //on successful login, return respective dashboards
            Customer account=cust.findByUsername(username);
            if(account == null)
                return null;
            //System.out.println(account.size());
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getName());
                return account;
            }
            else
                return null;

        }
        else if(type.equals("del"))
        {
            //check cust table
            Delivery account=del.findByUsername(username);
            if(account == null)
                return null;
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getName());
                return account;
            }
            else
                return null;

        }
        else if(type.equals("part"))
        {
            //check cust table
            Partner account=part.findByUsername(username);
            if(account == null)
                return null;
            if(account.getPassword().equals(password))
            {
                //session.setAttribute("Login",account.getStoreName());
                return account;
            }
            else
                return null;

        }
        //verify credentials
        return null;
    }

    @PostMapping(path = "/partner")
    public Partner partner(@RequestBody Partner p)
    {
        //register
        //accept partner input, save it in db
        //System.out.println(p);
        //Partner p=new Partner(storeName,storeLoc,username,password,contactno,email);
        part.save(p);
        System.out.println(p);
        System.out.println("Saved");
        return p;//present him home page, so he can login
    }
    @PostMapping(path="/customer")
    public Customer customer(@RequestBody Customer c)
    {
        //register
        //accept customer input, save it in db
        cust.save(c);
        System.out.println("cust reg");
        return c;//present him home page, so he can login
    }
    @PostMapping(path="/delivery")
    public Delivery delivery(@RequestBody Delivery d)
    {
        //register
        //accept delivery input, save it in db
        del.save(d);
        System.out.println("Del reg");
        return d;//present him home page, so he can login
    }
}
