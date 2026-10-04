# Hướng dẫn tự demo dự án jsp-servlet-demo

Dự án Maven Webapp (JSP/Servlet) chạy trên **Apache Tomcat 10.1+** (Jakarta Servlet API 6.0).

## Thông tin quan trọng (dùng lại mỗi lần)

| Mục | Giá trị |
|---|---|
| Thư mục dự án | `C:\DemoServlet` |
| Thư mục Tomcat | `C:\Users\lyduc\Downloads\apache-tomcat-10.1.60\apache-tomcat-10.1.60` |
| JDK | `C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot` (Java 17) |
| File WAR sau khi build | `C:\DemoServlet\target\jsp-servlet-demo.war` |
| Trang chủ | http://localhost:8080/jsp-servlet-demo/ |
| Servlet | http://localhost:8080/jsp-servlet-demo/hello |

---

## CÁCH 1 — Chạy bằng IntelliJ IDEA (Community Server Connectors)

### Bước 0: Mở dự án
1. Mở IntelliJ IDEA.
2. `File → Open` → chọn thư mục `C:\DemoServlet` → OK.
3. Đợi IntelliJ index và load Maven xong (thanh dưới cùng hết chạy).

### Bước 1: Cài plugin (chỉ làm 1 lần, nếu chưa thấy tab Servers)
1. `File → Settings → Plugins` (hoặc `Ctrl+Alt+S`).
2. Chọn tab **Marketplace**, gõ tìm `Community Server Connectors`.
3. Chọn plugin **Community Server Connectors** (của JetBrains) → **Install**.
4. **Restart IDE** để plugin có hiệu lực.

### Bước 2: Mở tab Servers
- Ở dải bảng điều khiển bên trái (hoặc dưới), nhấp tab có biểu tượng máy chủ (**Servers**).

### Bước 3: Tạo máy chủ Tomcat
1. Nhấp dấu cộng **(+)** hoặc liên kết **Create New Server...**.
2. Chọn danh mục **Apache Tomcat** → chọn phiên bản **Tomcat 10.x**.
3. Hệ thống hỏi đường dẫn cài đặt → trỏ đến:
   ```
   C:\Users\lyduc\Downloads\apache-tomcat-10.1.60\apache-tomcat-10.1.60
   ```
4. Bấm **Finish**.

### Bước 4: Build ra file WAR
1. Bên phải mở tab **Maven**.
2. Mở `jsp-servlet-demo → Lifecycle` → nhấp đúp **package**.
3. Đợi đến khi log hiện `BUILD SUCCESS` → file `target\jsp-servlet-demo.war` được tạo.

### Bước 5: Deploy (triển khai)
1. Chuột phải vào Server Tomcat vừa tạo → chọn **Add Deployment...**.
2. Chọn phương thức nạp dạng **File** → trỏ đến:
   ```
   C:\DemoServlet\target\jsp-servlet-demo.war
   ```
3. Bấm OK.

> Mẹo: có thể chọn **Artifact (war exploded)** thay vì file WAR, khi đó IntelliJ tự build lại và redeploy nhanh hơn mỗi lần sửa code.

### Bước 6: Khởi động và kiểm tra
1. Chuột phải vào Server Tomcat → chọn **Start Server**.
2. Mở tab **Output**, đợi thấy dòng log trắng:
   ```
   ... Server startup in [xxxx] ms
   ```
   → tức là server đã sẵn sàng.
3. Mở trình duyệt:
   - Trang chủ: http://localhost:8080/jsp-servlet-demo/
   - Servlet:   http://localhost:8080/jsp-servlet-demo/hello

### Bước 7: Dừng server
- Chuột phải Server Tomcat → **Stop Server** (quan trọng để giải phóng cổng 8080).

---

## CÁCH 2 — Chạy bằng Command Line (không cần IDE)

Mở **Command Prompt (cmd)** hoặc **Git Bash**.

### 2.1 Build
```bat
cd C:\DemoServlet
mvnw clean package
```
> Kết quả: `target\jsp-servlet-demo.war`.

### 2.2 Copy WAR vào webapps của Tomcat
```bat
copy target\jsp-servlet-demo.war "C:\Users\lyduc\Downloads\apache-tomcat-10.1.60\apache-tomcat-10.1.60\webapps\"
```

### 2.3 Khởi động Tomcat
```bat
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot
cd "C:\Users\lyduc\Downloads\apache-tomcat-10.1.60\apache-tomcat-10.1.60\bin"
catalina.bat run
```
> `catalina.bat run` chạy hiện log ngay trong cửa sổ (dễ xem lỗi). Đợi thấy dòng `Server startup in [xxxx] ms`.

### 2.4 Mở trình duyệt
- http://localhost:8080/jsp-servlet-demo/
- http://localhost:8080/jsp-servlet-demo/hello

### 2.5 Dừng Tomcat
Mở một cửa sổ cmd khác:
```bat
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot
cd "C:\Users\lyduc\Downloads\apache-tomcat-10.1.60\apache-tomcat-10.1.60\bin"
shutdown.bat
```

---

## LƯU Ý QUAN TRỌNG

1. **Tomcat 10.1+ dùng `jakarta.servlet.*`** (KHÔNG phải `javax.servlet.*`). Dự án này đã cấu hình đúng. Nếu sau này đổi sang Tomcat 9 thì phải đổi lại package import + dependency + `web.xml`.
2. **Port 8080 phải trống** trước khi start. Nếu đang có server khác chiếm (Spring Boot, Tomcat khác...) thì phải dừng trước, nếu không sẽ báo lỗi `Address already in use`.
3. **JAVA_HOME** phải trỏ đúng JDK 17 thì Tomcat mới chạy được.
4. Sau khi sửa code, phải **build lại WAR** (hoặc redeploy) rồi khởi động lại Tomcat mới thấy thay đổi.
