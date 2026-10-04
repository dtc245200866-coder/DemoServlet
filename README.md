# jsp-servlet-demo

Dự án **Maven Webapp** chuẩn cho Java JSP/Servlet, tương thích **Apache Tomcat 10.1+** (Jakarta Servlet API 6.0).

## Cấu trúc dự án (đầy đủ)

```
DemoServlet/
├── pom.xml                                  ← Cấu hình Maven (groupId com.codegym, artifactId jsp-servlet-demo, packaging war)
├── mvnw / mvnw.cmd                          ← Maven wrapper (chạy không cần cài Maven)
├── .mvn/wrapper/maven-wrapper.properties
└── src/main/
    ├── java/com/codegym/
    │   └── HelloServlet.java                ← Servlet mẫu (@WebServlet("/hello"), jakarta.servlet.*)
    └── webapp/
        ├── index.jsp                        ← Trang chủ, hiển thị thời gian hiện tại của máy chủ
        └── WEB-INF/
            └── web.xml                      ← Cấu hình Jakarta Servlet 6.0 (welcome-file index.jsp)
```

## Đóng gói

```bash
mvnw clean package
```

File WAR tạo tại: `target/jsp-servlet-demo.war`

## Chạy trên Tomcat 10.1+

1. Copy `target/jsp-servlet-demo.war` vào thư mục `webapps/` của Tomcat.
2. Khởi động Tomcat.
3. Truy cập:
   - Trang chủ (hiển thị giờ máy chủ): http://localhost:8080/jsp-servlet-demo/
   - Servlet:   http://localhost:8080/jsp-servlet-demo/hello

> Xem hướng dẫn chi tiết từng bước (IntelliJ + command line) trong file **HUONG_DAN_DEMO.md**.

## Lưu ý kỹ thuật

- **Tomcat 10.1+ dùng `jakarta.servlet.*`** (KHÔNG phải `javax.servlet.*`). Dự án đã cấu hình đúng Jakarta Servlet API 6.0.
- Java 17.
