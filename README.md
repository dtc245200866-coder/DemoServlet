# jsp-servlet-demo

Dự án Maven Webapp chuẩn cho Java JSP/Servlet, tương thích **Tomcat 10.1+** (Jakarta Servlet API 6.0).

## Cấu trúc

```
src/main/java/com/codegym/HelloServlet.java   → Servlet mẫu (jakarta.servlet.*)
src/main/webapp/index.jsp                      → Trang chủ mẫu
src/main/webapp/WEB-INF/web.xml                → Cấu hình Jakarta Servlet 6.0
```

## Đóng gói

```bash
mvn clean package
```

File WAR tạo tại: `target/jsp-servlet-demo.war`

## Chạy trên Tomcat 10.1+

1. Copy `target/jsp-servlet-demo.war` vào thư mục `webapps/` của Tomcat.
2. Khởi động Tomcat.
3. Truy cập:
   - Trang chủ: http://localhost:8080/jsp-servlet-demo/
   - Servlet:   http://localhost:8080/jsp-servlet-demo/hello

> Lưu ý: Tomcat 10.1+ dùng `jakarta.servlet.*`. Nếu dùng Tomcat 9 trở xuống (javax), cần đổi lại dependency và package import.
