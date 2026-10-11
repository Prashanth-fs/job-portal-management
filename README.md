# Job Portal Management

A Spring Boot + JSP web application where users register, log in, browse jobs and apply with a resume, and admins post jobs and review applicants.

## Features

**User**
- Register and log in (passwords are hashed with BCrypt)
- Dashboard showing jobs loaded from the database
- Apply for a job with qualification, experience and resume upload
- Confirmation message after the application is submitted

**Admin**
- Admin dashboard (role-based access, checked on the server)
- Post new jobs
- View everyone who applied and download their resumes

## Tech Stack

- Java 21
- Spring Boot (Spring MVC, Spring Data JPA, Spring Security for BCrypt)
- JSP + JSTL
- Oracle Database
- Maven (packaged as a WAR)

## Project Structure

```
src/main/java/com/nit
  config/       security configuration (password encoder)
  controller/   request handling (Home, User, Job, Application)
  entity/       User, Job, Application
  repository/   Spring Data JPA repositories
  service/imp/  service interfaces
  services/     service implementations
src/main/webapp/WEB-INF/pages   JSP pages
src/main/webapp/css             stylesheet
```

## Run It Locally

**You need:** Java 21, an Oracle database (XE / FREE), and VS Code (or Eclipse/STS). Maven downloads the libraries listed in `pom.xml` for you.

1. Clone the project:
   ```
   git clone https://github.com/Prashanth-fs/job-portal-management.git
   ```
2. In `src/main/resources`, copy `application-local.properties.example` to `application-local.properties` and put your own database URL, username and password.
3. Open the folder in VS Code (with the Extension Pack for Java and Spring Boot Extension Pack) and run `JobPortalManagementSpringBootApplication`, or import it into Eclipse/STS and run on Tomcat.
4. Open `http://localhost:8080/Job_Portal/`

Tables are created automatically on first run (`spring.jpa.hibernate.ddl-auto=update`).

## Making an Admin

New accounts are created with the role `USER`. To make one an admin, register normally and then run this in your database:

```sql
UPDATE JOB_PORTAL_USERS SET ROLE = 'ADMIN' WHERE EMAIL_ID = 'your-email@example.com';
COMMIT;
```

## Main Pages

| URL | Who | What |
|---|---|---|
| `/` | everyone | home page |
| `/register`, `/login` | everyone | create account / sign in |
| `/dashboard` | user | browse jobs |
| `/apply` | user | apply with resume |
| `/admin-dashboard` | admin | see posted jobs |
| `/post-job` | admin | add a new job |
| `/view-applicants` | admin | see applicants, download resumes |
