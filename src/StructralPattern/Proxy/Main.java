package StructralPattern.Proxy;


class Employee{

    private String name;
    private String department;
    private String position;

    private ProxyEmployeeManager proxyEmployeeManager;

    public Employee(String name, String department, String position) {
        this.name = name;
        this.department = department;
        this.position = position;
    }

    public void manageAnotherEmployee(String request){
        proxyEmployeeManager = new ProxyEmployeeManager();
        if(request.equals("Projeye Çalışan Ata")){
            proxyEmployeeManager.assignEmployeeToProject(this);
        }
        if(request.equals("Projeden Çalışan Sil")){
            proxyEmployeeManager.removeEmployeeFromProject(this);
        }
        if(request.equals("Çalışan Bilgilerini Güncelle")){
            proxyEmployeeManager.updateEmployeeRecord(this);
        }
        if(request.equals("Çalışan Bilgilerini Görüntüle")){
            proxyEmployeeManager.showEmployeeInfo(this);
        }
        if(request.equals("Çalışan Görevlendir")){
            proxyEmployeeManager.assignTaskToEmployee(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

class HumanResourcesEmployee extends Employee{

    public HumanResourcesEmployee(String name, String department, String position) {
        super(name, department, position);
    }

    @Override
    public void manageAnotherEmployee(String request) {
        super.manageAnotherEmployee(request);
    }
}

class WebDeveloperEmployee extends Employee{

    public WebDeveloperEmployee(String name, String department, String position) {
        super(name, department, position);
    }

    @Override
    public void manageAnotherEmployee(String request) {
        super.manageAnotherEmployee(request);
    }
}

class MobileDeveloperEmployee extends Employee{

    public MobileDeveloperEmployee(String name, String department, String position) {
        super(name, department, position);
    }

    @Override
    public void manageAnotherEmployee(String request) {
        super.manageAnotherEmployee(request);
    }
}

class CyberSecurityEmployee extends Employee{

    public CyberSecurityEmployee(String name, String department, String position) {
        super(name, department, position);
    }

    @Override
    public void manageAnotherEmployee(String request) {
        super.manageAnotherEmployee(request);
    }
}

interface IEmployeeManager{
    void assignEmployeeToProject(Employee attempter);
    void removeEmployeeFromProject(Employee attempter);
    void updateEmployeeRecord(Employee attempter);
    void showEmployeeInfo(Employee attempter);
    void assignTaskToEmployee(Employee attempter);
}

class RealEmployeeManager implements IEmployeeManager{

    @Override
    public void assignEmployeeToProject(Employee attempter) {
        System.out.println("Projeye çalışan atama sayfası yükleniyor...");
    }

    @Override
    public void removeEmployeeFromProject(Employee attempter) {
        System.out.println("Projeden çalışan çıkarma sayfası yükleniyor...");
    }

    @Override
    public void updateEmployeeRecord(Employee attempter) {
        System.out.println("Çalışan bilgilerini güncelleme sayafası yükleniyor...");
    }

    @Override
    public void showEmployeeInfo(Employee attempter) {
        System.out.println("Çalışan bilgilerine erişim sayfası yükleniyor...");
    }

    @Override
    public void assignTaskToEmployee(Employee attempter) {
        System.out.println("Çalışana görev atama sayfası yükleniyor...");
    }
}

class ProxyEmployeeManager implements IEmployeeManager{

    private RealEmployeeManager realEmployeeManager;

    @Override
    public void assignEmployeeToProject(Employee attempter) {
        if(attempter.getPosition().equals("Yönetici")){
            realEmployeeManager = new RealEmployeeManager();
            realEmployeeManager.assignEmployeeToProject(attempter);
        }
        else {
            System.out.println("Yetkisiz işlem girişimi! Girişimci : "+attempter.getName());
        }
    }

    @Override
    public void removeEmployeeFromProject(Employee attempter) {
        if(attempter.getPosition().equals("Yönetici")){
            realEmployeeManager = new RealEmployeeManager();
            realEmployeeManager.removeEmployeeFromProject(attempter);
        }
        else {
            System.out.println("Yetkisiz işlem girişimi! Girişimci : "+attempter.getName());
        }
    }

    @Override
    public void updateEmployeeRecord(Employee attempter) {
        if(attempter.getDepartment().equals("İnsan Kaynakları")){
            realEmployeeManager = new RealEmployeeManager();
            realEmployeeManager.updateEmployeeRecord(attempter);
        }
        else{
            System.out.println("Yetkisiz işlem girişimi! Girişimci : "+attempter.getName());
        }
    }

    @Override
    public void showEmployeeInfo(Employee attempter) {
        if(attempter.getDepartment().equals("İnsan Kaynakları") && attempter.getPosition().equals("Uzman")){
            realEmployeeManager = new RealEmployeeManager();
            realEmployeeManager.showEmployeeInfo(attempter);
        }
        else{
            System.out.println("Yetkisiz işlem girişimi! Girişimci : "+attempter.getName());
        }
    }

    @Override
    public void assignTaskToEmployee(Employee attempter) {
        realEmployeeManager = new RealEmployeeManager();
        realEmployeeManager.assignTaskToEmployee(attempter);
    }
}

public class Main {

    public static void main(String[] args) {

        Employee hrSpecialist = new HumanResourcesEmployee("Çalışan1","İnsan Kaynakları","Uzman");
        Employee hrIntern = new HumanResourcesEmployee("Çalışan2","İnsan Kaynakları","Stajyer");

        Employee webDeveloper = new WebDeveloperEmployee("Çalışan3","Software","Yönetici");
        Employee mobileDeveloper = new MobileDeveloperEmployee("Çalışan4","Software","Stajyer");

        Employee whiteRabbit = new CyberSecurityEmployee("Çalışan5","Siber Güvenlik","Uzman");
        ProxyEmployeeManager proxyEmployeeManager = new ProxyEmployeeManager();


        String request;

        request = "Projeye Çalışan Ata";

        hrSpecialist.manageAnotherEmployee(request);
        hrIntern.manageAnotherEmployee(request);
        webDeveloper.manageAnotherEmployee(request);
        mobileDeveloper.manageAnotherEmployee(request);
        whiteRabbit.manageAnotherEmployee(request);
        System.out.println("--");

        request = "Çalışan Bilgilerini Görüntüle";

        hrSpecialist.manageAnotherEmployee(request);
        hrIntern.manageAnotherEmployee(request);
        webDeveloper.manageAnotherEmployee(request);
        mobileDeveloper.manageAnotherEmployee(request);
        whiteRabbit.manageAnotherEmployee(request);


        System.out.println("-----------------------------");
        proxyEmployeeManager.assignEmployeeToProject(webDeveloper);
    }
}