package main;

import configuration.JPAConfig;
import entity.CustomerEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static CustomerRepository customerRepository = applicationContext.getBean("customerRepository", CustomerRepository.class);
    public static void main(String[] args) {
        // Delete all Customer
//        customerRepository.deleteAll();
//        System.out.println("Delete All Successfully!");

        //Create new Customer
//          createNewCustomer();
//          System.out.println("Create New Customer Successfully!");

        List<CustomerEntity> lisCus = (List<CustomerEntity>) customerRepository.findAll();
        List<CustomerEntity> lisCus1 = (List<CustomerEntity>) customerRepository.findByName("Thanh Tam");
        List<CustomerEntity> lisCus2 = (List<CustomerEntity>) customerRepository.findByEmail("loannguyen95@gmail.com");
        List<CustomerEntity> lisCus3 = (List<CustomerEntity>) customerRepository.findByPhone("0354222111");
        List<CustomerEntity> lisCusByName = customerRepository.getCustomerByName("Ty");
        List<CustomerEntity> listCustomerByPOrE = customerRepository.findByPhoneOrEmail("0384203346", "loannguyen95@gmail.com");
        List<CustomerEntity> lisCusByAgeAndSex = customerRepository.getCustomerByAgeAndSex();

        System.out.println("Find by Id");
        System.out.println(customerRepository.findById(3));
        
        System.out.println("* List find All: ");
        for (CustomerEntity customer:lisCus) {
            System.out.println(customer.toString());
        }

        System.out.println("* List find by Name: ");
        for (CustomerEntity customer:lisCus1) {
            System.out.println(customer.toString());
        }

        System.out.println("* List find by Email: ");
        for (CustomerEntity customer:lisCus2) {
            System.out.println(customer.toString());
        }

        System.out.println("* List find by Phone: ");
        for (CustomerEntity customer:lisCus3) {
            System.out.println(customer.toString());
        }


        for (CustomerEntity customer:lisCusByName) {
            System.out.println("* List find by Name: "+customer.getName());
            System.out.println(customer.toString());
        }

        System.out.println("* List find by Phone or Email: ");
        for (CustomerEntity cus: listCustomerByPOrE) {
            System.out.println(cus.toString());
        }

        System.out.println("* List Men Customer Have Age Between 20 and 30: ");
        for (CustomerEntity customer:lisCusByAgeAndSex) {
            System.out.println(customer.toString());
        }
    }
    public static void createNewCustomer(){
        CustomerEntity cus = new CustomerEntity();
        cus.setName("Thanh Tam");
        cus.setBirthdate(LocalDate.parse("1998-02-21"));
        cus.setSex("men");
        cus.setEmail("ngothanhtam98@gmail.com");
        cus.setPhone("0384203345");
        cus.setAddress("Dak Lak");
        CustomerEntity result = customerRepository.save(cus);
        if(result != null){
            System.out.println("A new book saved successfully, book ID = "+ cus.getId());
        }

        CustomerEntity cus1 = new CustomerEntity();
        cus1.setName("Thanh Dat");
        cus1.setBirthdate(LocalDate.parse("1998-11-20"));
        cus1.setSex("men");
        cus1.setEmail("thanhdatthichdabanh@gmail.com");
        cus1.setPhone("0385234345");
        cus1.setAddress("Quang Nam");
        CustomerEntity result1 = customerRepository.save(cus1);
        if(result1 != null){
            System.out.println("A new book saved successfully, book ID = "+ cus1.getId());
        }

        CustomerEntity cus2 = new CustomerEntity();
        cus2.setName("Ty Cold");
        cus2.setBirthdate(LocalDate.parse("1997-10-15"));
        cus2.setSex("men");
        cus2.setEmail("tycold@gmail.com");
        cus2.setPhone("0987212222");
        cus2.setAddress("Da Nang");
        CustomerEntity result2 = customerRepository.save(cus2);
        if(result2 != null){
            System.out.println("A new book saved successfully, book ID = "+ cus2.getId());
        }

        CustomerEntity cus3 = new CustomerEntity();
        cus3.setName("Nhat Tai");
        cus3.setBirthdate(LocalDate.parse("1996-01-20"));
        cus3.setSex("men");
        cus3.setEmail("nhattai96@gmail.com");
        cus3.setPhone("0835055054");
        cus3.setAddress("Da Nang");
        CustomerEntity result3 = customerRepository.save(cus3);
        if(result3 != null){
            System.out.println("A new book saved successfully, book ID = "+ cus3.getId());
        }

        CustomerEntity cus4 = new CustomerEntity();
        cus4.setName("Kim Ngan");
        cus4.setBirthdate(LocalDate.parse("2001-04-24"));
        cus4.setSex("women");
        cus4.setEmail("kimngan99@gmail.com");
        cus4.setPhone("0354222111");
        cus4.setAddress("Da Nang");
        CustomerEntity result4 = customerRepository.save(cus4);
        if(result4 != null){
            System.out.println("A new book saved successfully, book ID = "+ cus4.getId());
        }

        CustomerEntity cus5 = new CustomerEntity();
        cus5.setName("Loan Nguyen");
        cus5.setBirthdate(LocalDate.parse("1995-01-15"));
        cus5.setSex("women");
        cus5.setEmail("loannguyen95@gmail.com");
        cus5.setPhone("0389888999");
        cus5.setAddress("Phu Yen");
        CustomerEntity result5 = customerRepository.save(cus5);
        if(result5 != null){
            System.out.println("A new book saved successfully, book ID = "+ cus5.getId());
        }
    }
}
