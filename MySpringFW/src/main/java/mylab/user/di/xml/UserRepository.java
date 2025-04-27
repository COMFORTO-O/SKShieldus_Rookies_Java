package mylab.user.di.xml;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserRepository {

    private String dbType;

    public UserRepository() {}

    public String getDbType() { return dbType; }
    public void setDbType(String dbType) { this.dbType = dbType; }

    @PostConstruct
    public void init() {
        this.dbType = "MySQL";  // 객체 생성 후 자동으로 dbType 세팅
    }

    public boolean saveUser(String userId, String name) {
        System.out.println("사용자 저장: " + userId + ", " + name + " (DB: " + dbType + ")");
        return true;
    }
    
    @Override
    public String toString() {
        return "UserRepository [dbType=" + dbType + "]";
    }
}
