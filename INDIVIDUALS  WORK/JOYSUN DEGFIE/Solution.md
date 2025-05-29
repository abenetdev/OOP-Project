# Domain Solution: E-Learning System

## Overview

This solution models an E-Learning System using Object-Oriented Principles. It focuses on clarity, separating responsibilities, and managing the relationships between key entities like Users (Students, Instructors), Courses, Lessons, and Content. The design uses core classes and principles like hiding data details and structuring components logically.

## Core Classes

### 1. User Class (Base Class for different roles)

Represents a general user of the system. Specific roles like Student and Instructor will build upon this base.

**Attributes:**

| Name         | Data Type | Visibility | Rationale                                                        |
| :----------- | :-------- | :--------- | :--------------------------------------------------------------- |
| `userId`     | String    | `private`  | Unique identifier for the user.                                  |
| `name`       | String    | `private`  | User's full name.                                                |
| `email`      | String    | `private`  | User's email address, often used for login.                      |
| `password`   | String    | `private`  | Hashed password for authentication (never store plain text).     |
| `dateJoined` | Date      | `private`  | Date the user registered.                                        |

**Methods:**

| Name           | Parameters               | Return Type   | Visibility | Rationale                                                 |
| :------------- | :----------------------- | :------------ | :--------- | :-------------------------------------------------------- |
| `User(...)`    | (Initial attribute values) | (constructor) | `protected`| Creates a base user instance (used by subclasses).        |
| `getUserId()`  | -                        | String        | `public`   | Returns the user ID.                                      |
| `getName()`    | -                        | String        | `public`   | Returns the user's name.                                  |
| `getEmail()`   | -                        | String        | `public`   | Returns the user's email.                                 |
| `updateProfile()`| (new name, email, etc.)  | void          | `public`   | Allows the user to update their basic profile information. |
| `changePassword()`| `newPassword`: String    | boolean       | `public`   | Allows the user to change their password securely.        |

### 2. Student Class (Inherits from User)

Represents a learner enrolled in courses.

**Attributes:**

| Name              | Data Type      | Visibility | Rationale                                                          |
| :---------------- | :------------- | :--------- | :----------------------------------------------------------------- |
| `enrolledCourses` | List<Course>   | `private`  | List of courses the student is currently enrolled in (Association). |
| `progressData`    | Map<String, Double> | `private` | Tracks progress per course (e.g., CourseID -> Percentage Complete). |
| `grades`          | Map<String, String> | `private`  | Stores grades for courses or specific assessments (e.g., QuizID -> Grade). |

**Methods:**

| Name            | Parameters                 | Return Type   | Visibility | Rationale                                                              |
| :-------------- | :------------------------- | :------------ | :--------- | :--------------------------------------------------------------------- |
| `Student(...)`  | (User attributes)          | (constructor) | `public`   | Creates a new student instance, calling the base User constructor.     |
| `enroll()`      | `course`: Course           | void          | `public`   | Adds a course to the `enrolledCourses` list.                           |
| `viewProgress()`| `courseId`: String         | double        | `public`   | Retrieves the completion percentage for a specific course.             |
| `viewGrade()`   | `assessmentId`: String     | String        | `public`   | Retrieves the grade for a specific quiz or assessment.                 |
| `getEnrolledCourses()`| -                        | List<Course>  | `public`   | Returns the list of courses the student is enrolled in.                |
| `updateProgress()`| `courseId`: String, `progress`: double | void | `public` | Updates the progress percentage for a course.                          |

### 3. Instructor Class (Inherits from User)

Represents a user who creates and manages courses.

**Attributes:**

| Name           | Data Type      | Visibility | Rationale                                                           |
| :------------- | :------------- | :--------- | :------------------------------------------------------------------ |
| `coursesTaught`| List<Course>   | `private`  | List of courses created or managed by this instructor (Association). |
| `expertise`    | String         | `private`  | Field(s) of expertise for the instructor.                           |

**Methods:**

| Name           | Parameters               | Return Type   | Visibility | Rationale                                                                   |
| :------------- | :----------------------- | :------------ | :--------- | :-------------------------------------------------------------------------- |
| `Instructor(...)`| (User attributes)        | (constructor) | `public`   | Creates a new instructor instance, calling the base User constructor.       |
| `createCourse()` | (title, description, etc.) | Course        | `public`   | Creates a new course object and adds it to `coursesTaught`.                 |
| `addLesson()`    | `course`: Course, `lesson`: Lesson | void | `public`   | Adds a lesson to a specific course managed by the instructor.               |
| `gradeAssignment()`| `student`: Student, `assessmentId`: String, `grade`: String | void | `public` | Assigns a grade to a student's submission (updates Student's `grades`). |
| `getCoursesTaught()`| -                      | List<Course>  | `public`   | Returns the list of courses managed by the instructor.                      |

### 4. Course Class

Represents an online course offered on the platform.

**Attributes:**

| Name         | Data Type      | Visibility | Rationale                                                           |
| :----------- | :------------- | :--------- | :------------------------------------------------------------------ |
| `courseId`   | String         | `private`  | Unique identifier for the course.                                   |
| `title`      | String         | `private`  | Title of the course.                                                |
| `description`| String         | `private`  | Detailed description of the course content and objectives.        |
| `instructor` | Instructor     | `private`  | The instructor responsible for the course (Association).            |
| `modules`    | List<Module>   | `private`  | Ordered list of modules within the course (Aggregation).            |
| `enrolledStudents`| List<Student>| `private` | List of students enrolled in this course (Association).             |

**Methods:**

| Name          | Parameters                  | Return Type | Visibility | Rationale                                                       |
| :------------ | :-------------------------- | :---------- | :--------- | :-------------------------------------------------------------- |
| `Course(...)` | (Initial attribute values)  | (constructor) | `public`   | Creates a new course instance.                                  |
| `getCourseId()` | -                           | String      | `public`   | Returns the unique course ID.                                   |
| `getTitle()`    | -                           | String      | `public`   | Returns the course title.                                       |
| `getModules()`  | -                           | List<Module>| `public`   | Returns the list of modules in the course.                      |
| `addModule()`   | `module`: Module            | void        | `public`   | Adds a new module to the course structure.                      |
| `addStudent()`  | `student`: Student          | void        | `public`   | Adds a student to the `enrolledStudents` list.                  |
| `getEnrolledStudents()`| -                  | List<Student>| `public`  | Returns the list of students currently enrolled.                |

### 5. Module Class

Represents a logical section or unit within a Course.

**Attributes:**

| Name         | Data Type     | Visibility | Rationale                                                      |
| :----------- | :------------ | :--------- | :------------------------------------------------------------- |
| `moduleId`   | String        | `private`  | Unique identifier for the module.                              |
| `title`      | String        | `private`  | Title of the module.                                           |
| `lessons`    | List<Lesson>  | `private`  | Ordered list of lessons within this module (Aggregation).      |

**Methods:**

| Name        | Parameters                | Return Type  | Visibility | Rationale                                       |
| :---------- | :------------------------ | :----------- | :--------- | :---------------------------------------------- |
| `Module(...)` | (Initial attribute values)| (constructor)| `public`   | Creates a new module instance.                  |
| `getTitle()`  | -                         | String       | `public`   | Returns the module title.                       |
| `getLessons()`| -                         | List<Lesson> | `public`   | Returns the list of lessons in this module.     |
| `addLesson()` | `lesson`: Lesson          | void         | `public`   | Adds a new lesson to the module.                |

### 6. Lesson Class

Represents a single learning unit within a Module.

**Attributes:**

| Name        | Data Type          | Visibility | Rationale                                                            |
| :---------- | :----------------- | :--------- | :------------------------------------------------------------------- |
| `lessonId`  | String             | `private`  | Unique identifier for the lesson.                                    |
| `title`     | String             | `private`  | Title of the lesson.                                                 |
| `contentItems`| List<ContentItem>| `private`  | List of learning materials (video, text, quiz) for this lesson (Aggregation). |

**Methods:**

| Name            | Parameters                | Return Type        | Visibility | Rationale                                        |
| :-------------- | :------------------------ | :----------------- | :--------- | :----------------------------------------------- |
| `Lesson(...)`   | (Initial attribute values)| (constructor)      | `public`   | Creates a new lesson instance.                   |
| `getTitle()`      | -                         | String             | `public`   | Returns the lesson title.                        |
| `getContentItems()`| -                       | List<ContentItem>| `public`   | Returns the learning materials for this lesson.  |
| `addContentItem()`| `item`: ContentItem     | void               | `public`   | Adds a piece of content (video, quiz) to the lesson. |

### 7. ContentItem Class (Base Class for content types)

Represents a generic piece of learning content within a Lesson. Specific types will inherit from this.

**Attributes:**

| Name        | Data Type | Visibility | Rationale                            |
| :---------- | :-------- | :--------- | :----------------------------------- |
| `contentId` | String    | `private`  | Unique identifier for the content.   |
| `title`     | String    | `private`  | Title of the content item.           |

**Methods:**

| Name            | Parameters                | Return Type   | Visibility | Rationale                                                            |
| :-------------- | :------------------------ | :------------ | :--------- | :------------------------------------------------------------------- |
| `ContentItem(...)`| (Initial attribute values)| (constructor) | `protected`| Creates a base content item (used by subclasses like Video, Quiz). |
| `getContentId()`| -                         | String        | `public`   | Returns the content ID.                                              |
| `getTitle()`    | -                         | String        | `public`   | Returns the content title.                                           |
| `display()`     | -                         | void          | `abstract` | Abstract method: Subclasses must define how they are displayed.      |

*(Specific subclasses like `Video` (with `videoUrl`, `duration`), `Reading` (with `fileUrl` or `textContent`), and `Quiz` (with `questions`: List<String>, `answers`: Map) would inherit from `ContentItem` and implement the `display()` method accordingly.)*

### 8. Enrollment Class (Alternative/Optional)

Represents the relationship between a Student and a Course, especially if extra data is needed.

**Attributes:**

| Name            | Data Type | Visibility | Rationale                                  |
| :-------------- | :-------- | :--------- | :----------------------------------------- |
| `enrollmentId`  | String    | `private`  | Unique identifier for the enrollment.      |
| `student`       | Student   | `private`  | Reference to the enrolled student.       |
| `course`        | Course    | `private`  | Reference to the course enrolled in.     |
| `enrollmentDate`| Date      | `private`  | Date the student enrolled.               |
| `completionStatus`| double  | `private`  | Percentage completion (alternative to map in Student). |
| `finalGrade`    | String    | `private`  | Final grade for the course (alternative). |

*(If using this class, `Student.enrolledCourses` and `Course.enrolledStudents` might hold `Enrollment` objects instead, or a central manager would handle enrollments.)*

## OOP Principles Applied

*   **Encapsulation:** All crucial data within classes (like `userId`, `courseId`, `grades`, `lessons`) is kept `private`. Access is controlled through public methods (like `getName()`, `enroll()`, `addLesson()`), ensuring data integrity and hiding implementation details.
*   **Inheritance:** `Student` and `Instructor` classes inherit common properties and behaviors (like `userId`, `name`, `updateProfile()`) from the base `User` class. Similarly, specific content types like `Video`, `Reading`, and `Quiz` would inherit from a base `ContentItem` class, promoting code reuse and a common structure.
*   **Abstraction:** Users of the system interact with higher-level concepts like `Course` and `Lesson` without needing to know the exact details of how `ContentItems` are stored or displayed. The `ContentItem`'s `display()` method is abstract, forcing subclasses to provide their specific way of presenting content, hiding the differences behind a common interface.
*   **Modularity:** Each class represents a distinct concept (User, Course, Lesson, Content) with specific responsibilities. This separation makes the system easier to develop, test, and maintain. Changes to how Quizzes work, for example, would primarily affect the `Quiz` class.
*   **Association/Aggregation:** Relationships are modeled using object references. A `Course` *has* an `Instructor` (Association). A `Course` *contains* a list of `Module` objects, and a `Module` *contains* a list of `Lesson` objects (Aggregation - a whole-part relationship modeled using `List`). Using dynamic collections (`List`, `Map`) allows flexibility in managing these relationships (e.g., a course can have any number of modules or students).

## Potential Enhancements / Alternatives

*   **Central Manager Class:** An `ElearningPlatformManager` could act as a central point to manage users, courses, and enrollments, simplifying interactions for the outside world (like a main application).
*   **Gamification:** Introduce concepts like `Badge` or `Points` classes, associating them with `Student` profiles based on completing courses or achieving high scores.
*   **Personalized Learning:** Add attributes or logic to track learning styles or recommend courses based on a `Student`'s history or interests.
*   **Assessment Variety:** Expand the `ContentItem` hierarchy to include more complex `Assignment` types beyond simple `Quiz` objects.
*   **Discussion Forum:** Add `Forum` and `Post` classes, linking them to `Course` and `User` objects to enable interaction.


# Domain 2: E-Learning System - Solution

...(previous content like Object Identification Table)...

## 2. Detailed Class Design: Attribute and Method Tables

Below are the detailed attribute and method tables for each class identified in the E-Learning System.

---
### Class: `User` (Abstract)
**Description:** Base class for all individuals interacting with the system.
**Attributes:**
| Attribute Name     | Data Type       | Visibility | Rationale / Description                                     |
|--------------------|-----------------|------------|-------------------------------------------------------------|
| `userID`           | `String`        | `private`  | Unique identifier (e.g., UUID). Generated internally.       |
| `username`         | `String`        | `private`  | User's unique login name.                                   |
| `passwordHash`     | `String`        | `private`  | Securely stored hash of the user's password.                |
| `email`            | `String`        | `private`  | User's unique email address. Used for login and communication.|
| `firstName`        | `String`        | `private`  | User's first name.                                          |
| `lastName`         | `String`        | `private`  | User's last name.                                           |
| `dateRegistered`   | `LocalDateTime` | `private`  | Timestamp of when the user registered.                        |
| `role`             | `RoleEnum`      | `private`  | Type of user (Student, Instructor, Admin).                  |
| `isActive`         | `boolean`       | `private`  | Status of the user account (active/inactive).               |

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                        |
|-------------------------|------------------------------------------------|-------------------|------------|----------------------------------------------------------------|
| `User(userID, username, password, email, firstName, lastName, role)` | `String, String, String, String, String, String, RoleEnum` | constructor    | `public`   | Constructor for creating a User. (Password will be hashed). |
| `login(password)`       | `String password`                              | `boolean`         | `public`   | Verifies provided password against stored hash.                  |
| `logout()`              |                                                | `void`            | `public`   | Handles user logout session.                                   |
| `updateProfileDetails(firstName, lastName, email)` | `String, String, String`                 | `void`            | `public`   | Allows user to update their basic profile information.         |
| `changePassword(oldPassword, newPassword)` | `String, String`                           | `boolean`         | `public`   | Allows user to change their password after verifying old one.  |
| `getProfileInfo()`      |                                                | `Map<String,String>`| `public`   | Returns a map of user profile information (excluding sensitive).|
| `verifyPassword(password)`| `String password`                              | `boolean`         | `protected`| Helper to verify a password.                                   |
| `hashPassword(password)`| `String password`                              | `String`          | `private`  | Hashes the given password.                                     |
| `getUserID()`           |                                                | `String`          | `public`   | Getter for `userID`.                                           |
| `getUsername()`         |                                                | `String`          | `public`   | Getter for `username`.                                         |
| `getEmail()`            |                                                | `String`          | `public`   | Getter for `email`.                                            |
| `getFirstName()`        |                                                | `String`          | `public`   | Getter for `firstName`.                                        |
| `getLastName()`         |                                                | `String`          | `public`   | Getter for `lastName`.                                         |
| `getDateRegistered()`   |                                                | `LocalDateTime`   | `public`   | Getter for `dateRegistered`.                                   |
| `getRole()`             |                                                | `RoleEnum`        | `public`   | Getter for `role`.                                             |
| `isActive()`            |                                                | `boolean`         | `public`   | Getter for `isActive`.                                         |
| `setActive(isActive)`   | `boolean isActive`                             | `void`            | `protected`| Setter for `isActive` (usually by Admin).                      |

---
### Enum: `RoleEnum`
**Description:** Defines the possible roles a User can have.
**Values:**
| Value       | Description                  |
|-------------|------------------------------|
| `STUDENT`   | A learner in the system.     |
| `INSTRUCTOR`| A teacher/creator of courses.|
| `ADMIN`     | A system administrator.      |

---
### Class: `Student` (Extends `User`)
**Description:** Represents a learner who enrolls in courses.
**Attributes:**
| Attribute Name          | Data Type                  | Visibility | Rationale / Description                                     |
|-------------------------|----------------------------|------------|-------------------------------------------------------------|
| `enrolledCourses`       | `List<Enrollment>`         | `private`  | List of courses the student is currently enrolled in.       |
| `completedCoursesCount` | `int`                      | `private`  | Counter for courses completed by the student.               |

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                         |
|-------------------------|------------------------------------------------|-------------------|------------|-----------------------------------------------------------------|
| `Student(userID, username, password, email, firstName, lastName)` | (as User constructor)                      | constructor    | `public`   | Constructor, calls super() and sets role to STUDENT.          |
| `enrollInCourse(course)`| `Course course`                                | `Enrollment`      | `public`   | Enrolls the student in a given course. Creates Enrollment object. |
| `dropCourse(enrollment)`| `Enrollment enrollment`                        | `boolean`         | `public`   | Allows a student to drop an enrolled course.                  |
| `viewEnrolledCourses()` |                                                | `List<Enrollment>`| `public`   | Returns the list of courses the student is enrolled in.       |
| `viewCourseProgress(course)`| `Course course`                              | `List<Progress>`  | `public`   | Shows the student's progress for a specific course.           |
| `submitAssessment(assessment, submissionContent)` | `Assessment assessment, String submissionContent` | `Submission`    | `public`   | Allows student to submit work for an assessment.              |
| `getEnrollmentForCourse(courseID)` | `String courseID`                         | `Enrollment`      | `public`   | Retrieves the specific enrollment object for a course.        |
| `getEnrolledCourses()`    |                                                | `List<Enrollment>`| `public`   | Getter for `enrolledCourses`.                                 |
| `incrementCompletedCourses()`|                                             | `void`            | `public`   | Increments `completedCoursesCount`.                           |

---
### Class: `Instructor` (Extends `User`)
**Description:** Represents a teacher who creates and manages courses.
**Attributes:**
| Attribute Name     | Data Type          | Visibility | Rationale / Description                                     |
|--------------------|--------------------|------------|-------------------------------------------------------------|
| `bio`              | `String`           | `private`  | A short biography or description of the instructor.         |
| `expertiseAreas`   | `List<String>`     | `private`  | List of subjects or areas the instructor is skilled in.     |
| `coursesTaught`    | `List<Course>`     | `private`  | List of courses created or taught by this instructor.       |

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                       |
|-------------------------|------------------------------------------------|-------------------|------------|---------------------------------------------------------------|
| `Instructor(userID, username, password, email, firstName, lastName, bio, expertise)` | (as User constructor plus bio, expertise) | constructor    | `public`   | Constructor, calls super() and sets role to INSTRUCTOR.     |
| `createCourse(title, description, category, price)` | `String, String, String, double`         | `Course`          | `public`   | Creates a new course authored by this instructor.             |
| `updateCourseDetails(course, details)` | `Course course, Map<String,Object> details` | `boolean`         | `public`   | Modifies details of an existing course they own.              |
| `publishCourse(course)` | `Course course`                                | `boolean`         | `public`   | Makes a course available for enrollment.                      |
| `unpublishCourse(course)`| `Course course`                              | `boolean`         | `public`   | Removes a course from being publicly available.             |
| `addModuleToCourse(course, module)` | `Course course, Module module`               | `boolean`         | `public`   | Adds a new module to one of their courses.                  |
| `addLessonToModule(module, lesson)` | `Module module, Lesson lesson`               | `boolean`         | `public`   | Adds a new lesson to a module within their course.          |
| `addContentToLesson(lesson, contentItem)` | `Lesson lesson, ContentItem contentItem`   | `boolean`         | `public`   | Adds learning material to a lesson.                           |
| `gradeSubmission(submission, gradeValue, feedback)` | `Submission submission, double gradeValue, String feedback` | `Grade`         | `public`   | Grades a student's submission and provides feedback.        |
| `viewStudentSubmissions(assessment)` | `Assessment assessment`                      | `List<Submission>`| `public`   | Views all submissions for a particular assessment.            |
| `getBio()`              |                                                | `String`          | `public`   | Getter for `bio`.                                             |
| `setBio(bio)`           | `String bio`                                   | `void`            | `public`   | Setter for `bio`.                                             |
| `getExpertiseAreas()`   |                                                | `List<String>`    | `public`   | Getter for `expertiseAreas`.                                  |
| `addExpertiseArea(area)`| `String area`                                  | `void`            | `public`   | Adds an area of expertise.                                    |
| `getCoursesTaught()`    |                                                | `List<Course>`    | `public`   | Getter for `coursesTaught`.                                   |

---
### Class: `Administrator` (Extends `User`)
**Description:** Manages the overall system, users, and settings.
**Attributes:**
| Attribute Name     | Data Type      | Visibility | Rationale / Description                                     |
|--------------------|----------------|------------|-------------------------------------------------------------|
| `permissions`      | `List<String>` | `private`  | List of administrative permissions (e.g., "MANAGE_USERS").  |

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                        |
|-------------------------|------------------------------------------------|-------------------|------------|----------------------------------------------------------------|
| `Administrator(userID, username, password, email, firstName, lastName, permissions)` | (as User constr. + permissions) | constructor    | `public`   | Constructor, calls super() and sets role to ADMIN.             |
| `manageUserAccount(userID, action)` | `String userID, UserActionEnum action`       | `boolean`         | `public`   | Performs actions like activate/deactivate/delete user account. |
| `assignRoleToUser(user, role)` | `User user, RoleEnum role`                   | `boolean`         | `public`   | Changes the role of a user.                                    |
| `viewSystemAnalytics()` |                                                | `Map<String,Object>`| `public`   | Retrieves overall system usage statistics.                       |
| `manageCourseCategories(action, categoryName)` | `String action, String categoryName`     | `boolean`         | `public`   | Add/edit/delete course categories.                             |
| `getPermissions()`      |                                                | `List<String>`    | `public`   | Getter for `permissions`.                                      |
| `addPermission(permission)`| `String permission`                          | `void`            | `public`   | Adds a permission.                                             |

---
### Class: `Course`
**Description:** Represents a structured online learning program.
**Attributes:**
| Attribute Name     | Data Type                  | Visibility | Rationale / Description                                       |
|--------------------|----------------------------|------------|---------------------------------------------------------------|
| `courseID`         | `String`                   | `private`  | Unique identifier for the course.                             |
| `title`            | `String`                   | `private`  | The main title of the course.                                 |
| `description`      | `String`                   | `private`  | A detailed description of the course content and objectives.  |
| `instructor`       | `Instructor`               | `private`  | The instructor responsible for this course. (Reference to Instructor object) |
| `category`         | `String`                   | `private`  | Category the course belongs to (e.g., "Programming", "Design").|
| `modules`          | `List<Module>`             | `private`  | Ordered list of modules that make up the course.              |
| `price`            | `double`                   | `private`  | Cost of the course (0.0 for free courses).                    |
| `publishedDate`    | `LocalDateTime`            | `private`  | Date when the course was made publicly available.             |
| `isPublished`      | `boolean`                  | `private`  | Current publication status of the course.                     |
| `enrollmentCount`  | `static int`               | `private`  | (Alternative: track via Enrollment list size) Number of students enrolled. |
| `averageRating`    | `double`                   | `private`  | Average rating given by students (if ratings are implemented).|

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                       |
|-------------------------|------------------------------------------------|-------------------|------------|---------------------------------------------------------------|
| `Course(courseID, title, description, instructor, category, price)` | `String, String, String, Instructor, String, double` | constructor | `public`   | Constructor to create a new course.                           |
| `addModule(module)`     | `Module module`                                | `void`            | `public`   | Adds a module to the course.                                  |
| `removeModule(moduleID)`| `String moduleID`                              | `boolean`         | `public`   | Removes a module from the course by its ID.                   |
| `getModules()`          |                                                | `List<Module>`    | `public`   | Returns the list of modules in the course.                    |
| `publish()`             |                                                | `void`            | `public`   | Sets `isPublished` to true and `publishedDate`.               |
| `unpublish()`           |                                                | `void`            | `public`   | Sets `isPublished` to false.                                  |
| `updateDetails(title, description, category, price)` | `String, String, String, double`        | `void`            | `public`   | Updates course details.                                       |
| `getCourseID()`         |                                                | `String`          | `public`   | Getter.                                                       |
| `getTitle()`            |                                                | `String`          | `public`   | Getter.                                                       |
| `getDescription()`      |                                                | `String`          | `public`   | Getter.                                                       |
| `getInstructor()`       |                                                | `Instructor`      | `public`   | Getter.                                                       |
| `getCategory()`         |                                                | `String`          | `public`   | Getter.                                                       |
| `getPrice()`            |                                                | `double`          | `public`   | Getter.                                                       |
| `isPublished()`         |                                                | `boolean`         | `public`   | Getter.                                                       |
| `getPublishedDate()`    |                                                | `LocalDateTime`   | `public`   | Getter.                                                       |

---
### Class: `Module`
**Description:** A logical section or unit within a Course.
**Attributes:**
| Attribute Name     | Data Type          | Visibility | Rationale / Description                                   |
|--------------------|--------------------|------------|-----------------------------------------------------------|
| `moduleID`         | `String`           | `private`  | Unique identifier for the module.                         |
| `title`            | `String`           | `private`  | Title of the module.                                      |
| `description`      | `String`           | `private`  | Brief description of the module's content.                |
| `sequenceOrder`    | `int`              | `private`  | Order in which this module appears in the course.         |
| `lessons`          | `List<Lesson>`     | `private`  | Ordered list of lessons within this module.               |

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                     |
|-------------------------|------------------------------------------------|-------------------|------------|-------------------------------------------------------------|
| `Module(moduleID, title, description, sequenceOrder)` | `String, String, String, int`              | constructor    | `public`   | Constructor for creating a new module.                      |
| `addLesson(lesson)`     | `Lesson lesson`                                | `void`            | `public`   | Adds a lesson to this module.                               |
| `removeLesson(lessonID)`| `String lessonID`                              | `boolean`         | `public`   | Removes a lesson by its ID.                                 |
| `getLessons()`          |                                                | `List<Lesson>`    | `public`   | Returns the list of lessons in this module.                 |
| `updateDetails(title, description, sequenceOrder)` | `String, String, int`                    | `void`            | `public`   | Updates module details.                                     |
| `getModuleID()`         |                                                | `String`          | `public`   | Getter.                                                     |
| `getTitle()`            |                                                | `String`          | `public`   | Getter.                                                     |
| `getDescription()`      |                                                | `String`          | `public`   | Getter.                                                     |
| `getSequenceOrder()`    |                                                | `int`             | `public`   | Getter.                                                     |

---
### Class: `Lesson`
**Description:** A specific learning segment within a Module.
**Attributes:**
| Attribute Name     | Data Type              | Visibility | Rationale / Description                                     |
|--------------------|------------------------|------------|-------------------------------------------------------------|
| `lessonID`         | `String`               | `private`  | Unique identifier for the lesson.                           |
| `title`            | `String`               | `private`  | Title of the lesson.                                        |
| `description`      | `String`               | `private`  | Brief description of the lesson's content.                  |
| `sequenceOrder`    | `int`                  | `private`  | Order in which this lesson appears in the module.           |
| `contentItems`     | `List<ContentItem>`    | `private`  | Ordered list of learning materials within this lesson.      |
| `estimatedDurationMinutes` | `int`          | `private`  | Total estimated time to complete the lesson.                |

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                       |
|-------------------------|------------------------------------------------|-------------------|------------|---------------------------------------------------------------|
| `Lesson(lessonID, title, description, sequenceOrder)` | `String, String, String, int`              | constructor    | `public`   | Constructor for creating a new lesson.                        |
| `addContentItem(item)`  | `ContentItem item`                             | `void`            | `public`   | Adds a piece of content (video, quiz, etc.) to the lesson.  |
| `removeContentItem(contentID)`| `String contentID`                         | `boolean`         | `public`   | Removes a content item by its ID.                             |
| `getContentItems()`     |                                                | `List<ContentItem>`| `public`   | Returns the list of content items in this lesson.             |
| `updateDetails(title, description, sequenceOrder)` | `String, String, int`                    | `void`            | `public`   | Updates lesson details.                                       |
| `calculateEstimatedDuration()` |                                         | `void`            | `private`  | Calculates and updates `estimatedDurationMinutes` based on content. |
| `getLessonID()`         |                                                | `String`          | `public`   | Getter.                                                       |
| `getTitle()`            |                                                | `String`          | `public`   | Getter.                                                       |
| `getDescription()`      |                                                | `String`          | `public`   | Getter.                                                       |
| `getSequenceOrder()`    |                                                | `int`             | `public`   | Getter.                                                       |
| `getEstimatedDurationMinutes()`|                                         | `int`             | `public`   | Getter.                                                       |

---
### Class: `ContentItem` (Abstract)
**Description:** Base class for any piece of learning material.
**Attributes:**
| Attribute Name     | Data Type          | Visibility | Rationale / Description                                     |
|--------------------|--------------------|------------|-------------------------------------------------------------|
| `contentID`        | `String`           | `private`  | Unique identifier for the content item.                     |
| `title`            | `String`           | `private`  | Title of the content item.                                  |
| `contentType`      | `ContentTypeEnum`  | `protected`| Type of content (Video, Text, Quiz).                        |
| `estimatedCompletionTimeMinutes` | `int` | `private`  | Estimated time to consume/complete this item.             |

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                       |
|-------------------------|------------------------------------------------|-------------------|------------|---------------------------------------------------------------|
| `ContentItem(contentID, title, contentType)` | `String, String, ContentTypeEnum`        | constructor    | `protected`| Constructor for subclasses.                                   |
| `display()`             |                                                | `void`            | `public abstract`| Abstract method for displaying the content.                   |
| `getContentID()`        |                                                | `String`          | `public`   | Getter.                                                       |
| `getTitle()`            |                                                | `String`          | `public`   | Getter.                                                       |
| `getContentType()`      |                                                | `ContentTypeEnum` | `public`   | Getter.                                                       |
| `getEstimatedCompletionTimeMinutes()`|                                  | `int`             | `public`   | Getter.                                                       |
| `setEstimatedCompletionTimeMinutes(minutes)`| `int minutes`               | `void`            | `protected`| Setter.                                                       |


---
### Enum: `ContentTypeEnum`
**Description:** Defines the types of learning content.
**Values:**
| Value       | Description                       |
|-------------|-----------------------------------|
| `VIDEO`     | Video lecture or demonstration.   |
| `TEXT_DOCUMENT`| PDF, article, or text reading.  |
| `QUIZ`      | Interactive set of questions.     |
| `ASSIGNMENT`| A task to be submitted by student.|
| `EXTERNAL_LINK`| A link to an external resource. |

---
**(Continue with detailed tables for `Video`, `TextDocument`, `Quiz`, `Question`, `Enrollment`, `Progress`, `Assessment`, `Submission`, `Grade`, `DiscussionForum`, `ForumPost`, `Notification` and any relevant Enums like `EnrollmentStatusEnum`, `ProgressStatusEnum`, `QuestionTypeEnum`.)**

Example for `Quiz`:
---
### Class: `Quiz` (Extends `ContentItem`)
**Description:** An interactive set of questions for assessment.
**Attributes:**
| Attribute Name     | Data Type          | Visibility | Rationale / Description                                        |
|--------------------|--------------------|------------|----------------------------------------------------------------|
| `questions`        | `List<Question>`   | `private`  | List of questions that make up the quiz.                       |
| `timeLimitMinutes` | `int`              | `private`  | Maximum time allowed to complete the quiz (0 for no limit).    |
| `passingScorePercentage`| `double`        | `private`  | Minimum percentage required to pass the quiz.                  |
| `attemptsAllowed`  | `int`              | `private`  | Number of times a student can attempt the quiz (0 for unlimited).|
| `shuffleQuestions` | `boolean`          | `private`  | Whether to shuffle question order for each attempt.            |

**Methods:**
| Method Name             | Parameters                                     | Return Type       | Visibility | Rationale / Description                                      |
|-------------------------|------------------------------------------------|-------------------|------------|--------------------------------------------------------------|
| `Quiz(contentID, title, timeLimit, passingScore, attempts)` | `String, String, int, double, int` | constructor | `public`   | Constructor. Sets contentType to QUIZ.                     |
| `addQuestion(question)` | `Question question`                            | `void`            | `public`   | Adds a question to the quiz.                                 |
| `removeQuestion(questionID)`| `String questionID`                          | `boolean`         | `public`   | Removes a question by its ID.                                |
| `getQuestions()`        |                                                | `List<Question>`  | `public`   | Returns the list of questions.                               |
| `startAttempt(student)` | `Student student`                              | `QuizAttempt`     | `public`   | Initiates a new attempt for a student.                       |
| `submitAttempt(attempt, answers)` | `QuizAttempt attempt, Map<String,String> answers` | `double`    | `public`   | Submits student's answers and calculates score.              |
| `display()`             |                                                | `void`            | `public`   | (Overrides ContentItem) Displays quiz instructions/start page. |
| `getTimeLimitMinutes()` |                                                | `int`             | `public`   | Getter.                                                      |
| `getPassingScorePercentage()`|                                           | `double`          | `public`   | Getter.                                                      |

---

This process needs to be repeated for **ALL** classes identified. It's a detailed and time-consuming step, but crucial for a good design.

**Next Steps after completing Attribute/Method Tables:**

1.  **Refine Relationships:**
    *   Clearly define associations (e.g., a `Student` *is enrolled in* many `Course`s through `Enrollment`).
    *   Identify Aggregation vs. Composition (e.g., `Course` *is composed of* `Module`s - if a Course is deleted, its Modules are too. `Instructor` *has an association with* `Course` - if an Instructor leaves, Courses might remain or be reassigned).
2.  **Explain OOP Principles:**
    *   **Encapsulation:** How data hiding is achieved (private attributes, public getters/setters).
    *   **Abstraction:** How essential features are exposed while hiding complex implementation (e.g., `ContentItem.display()` abstract method).
    *   **Inheritance:** Where it's used (`Student extends User`, `Video extends ContentItem`) and why (code reuse, polymorphism).
    *   **Polymorphism:** How different `ContentItem` types can be treated uniformly (e.g., a `Lesson` has a `List<ContentItem>`).
3.  **Update UML Class Diagram:** The diagram you drafted earlier will now be much more detailed, showing full attribute/method signatures and clearer relationship types.

**Action for GitHub:**
*   As you complete the detailed tables for each class (or a logical group of classes), commit them to your branch (e.g., `feature/elearning-detailed-design`).
    ```bash
    git add Domain_2_ELearning_System/Domain_2_Solution.md
    git commit -m "docs: Add detailed attribute/method tables for User, Student, Instructor classes"
    git push origin feature/elearning-detailed-design
    ```
*   Regularly create Pull Requests for review by your team.

This will be a significant update to your `Domain_2_Solution.md` file. Take your time and be thorough! Let me know if you want to focus on a specific class next or if you have questions as you proceed.

...(previous content: Object ID table, Attribute/Method tables)...

## 3. Detailed Relationships Between Classes

This section outlines the relationships between the classes in the E-Learning System.

---
### Inheritance / Realization

*   **`User` and its Subclasses (`Student`, `Instructor`, `Administrator`):**
    *   **Relationship Type:** Inheritance (Generalization/Specialization)
    *   **Description:** `Student`, `Instructor`, and `Administrator` are specialized types of `User`. They inherit common attributes (like `userID`, `username`, `email`) and methods (like `login()`, `updateProfileDetails()`) from the `User` class. `User` is an abstract class.
    *   **Multiplicity:**
        *   `User` <|-- `Student`
        *   `User` <|-- `Instructor`
        *   `User` <|-- `Administrator`
    *   **Rationale:** Promotes code reuse and establishes an "is-a" relationship, allowing for polymorphic behavior (e.g., a list of `User` objects can contain `Student`, `Instructor`, or `Admin` instances).

*   **`ContentItem` and its Subclasses (`Video`, `TextDocument`, `Quiz`, `AssignmentLink`):**
    *   **Relationship Type:** Inheritance (Generalization/Specialization)
    *   **Description:** `Video`, `TextDocument`, `Quiz`, etc., are specific types of `ContentItem`. They inherit common attributes (like `contentID`, `title`) and must implement abstract methods (like `display()`). `ContentItem` is an abstract class.
    *   **Multiplicity:**
        *   `ContentItem` <|-- `Video`
        *   `ContentItem` <|-- `TextDocument`
        *   `ContentItem` <|-- `Quiz`
        *   `ContentItem` <|-- `AssignmentLink` (if modeling assignments as a type of content)
    *   **Rationale:** Allows for a common interface to manage diverse content types within a `Lesson`. Facilitates polymorphism.

---
### Composition (Strong "Whole-Part" Relationship - Part cannot exist without the Whole)

*   **`Course` and `Module`:**
    *   **Relationship Type:** Composition
    *   **Description:** A `Course` is composed of one or more `Module`s. A `Module` is an integral part of a `Course` and cannot exist independently. If a `Course` is deleted, its `Module`s are also deleted.
    *   **Multiplicity:**
        *   `Course` "1" o-- "1..*" `Module` (A Course has one or more Modules)
    *   **Implementation:** `Course` class will have a `List<Module> modules;` attribute.

*   **`Module` and `Lesson`:**
    *   **Relationship Type:** Composition
    *   **Description:** A `Module` is composed of one or more `Lesson`s. A `Lesson` belongs exclusively to one `Module`. If a `Module` is deleted, its `Lesson`s are also deleted.
    *   **Multiplicity:**
        *   `Module` "1" o-- "1..*" `Lesson` (A Module has one or more Lessons)
    *   **Implementation:** `Module` class will have a `List<Lesson> lessons;` attribute.

*   **`Lesson` and `ContentItem`:**
    *   **Relationship Type:** Composition
    *   **Description:** A `Lesson` is composed of one or more `ContentItem`s. `ContentItem`s are the actual learning materials and are part of a specific `Lesson`.
    *   **Multiplicity:**
        *   `Lesson` "1" o-- "1..*" `ContentItem` (A Lesson has one or more ContentItems)
    *   **Implementation:** `Lesson` class will have a `List<ContentItem> contentItems;` attribute.

*   **`Quiz` and `Question`:**
    *   **Relationship Type:** Composition
    *   **Description:** A `Quiz` is composed of one or more `Question`s. `Question`s are specific to a `Quiz` and do not exist independently.
    *   **Multiplicity:**
        *   `Quiz` "1" o-- "1..*" `Question` (A Quiz has one or more Questions)
    *   **Implementation:** `Quiz` class will have a `List<Question> questions;` attribute.

---
### Aggregation (Weaker "Whole-Part" Relationship - Part can exist independently)

*   **`Instructor` and `Course`:**
    *   **Relationship Type:** Aggregation (often represented as a directed association if one side "manages" or "owns" the other, but the owned part can exist independently or be reassigned).
    *   **Description:** An `Instructor` creates and manages one or more `Course`s. A `Course` is taught by an `Instructor`. If an `Instructor` account is deactivated, their `Course`s might still exist in the system (e.g., be reassigned or archived).
    *   **Multiplicity:**
        *   `Instructor` "1" <>-- "0..*" `Course` (An Instructor teaches zero or more Courses)
        *   `Course` "1" -- "1" `Instructor` (A Course is taught by one Instructor - can be extended to multiple instructors later if needed with a many-to-many)
    *   **Implementation:** `Instructor` class has `List<Course> coursesTaught;`. `Course` class has an `Instructor instructor;` attribute.

---
### Association (General Relationship - Objects are related but can exist independently)

*   **`Student` and `Course` (via `Enrollment` - Association Class):**
    *   **Relationship Type:** Many-to-Many Association, resolved by an Association Class `Enrollment`.
    *   **Description:** A `Student` can enroll in many `Course`s, and a `Course` can have many `Student`s enrolled. The `Enrollment` class captures details specific to this relationship, like enrollment date and status.
    *   **Multiplicity:**
        *   `Student` "1" -- "0..*" `Enrollment`
        *   `Course` "1" -- "0..*" `Enrollment`
        *   `Enrollment` connects one `Student` to one `Course`.
    *   **Implementation:** `Student` has `List<Enrollment> enrolledCourses;`. `Course` might have a method `getEnrolledStudents()` which queries `Enrollment` objects. `Enrollment` has `Student student;` and `Course course;` attributes.

*   **`Enrollment` and `Progress`:**
    *   **Relationship Type:** One-to-Many Association (or Composition if Progress is strictly tied to an Enrollment's lifecycle). Let's consider it a strong association leaning towards composition for tracking within an enrollment.
    *   **Description:** An `Enrollment` (a student in a course) has multiple `Progress` records, one for each trackable item (e.g., Lesson, ContentItem) within that course for that student.
    *   **Multiplicity:**
        *   `Enrollment` "1" -- "0..*" `Progress` (An Enrollment tracks zero or more Progress items)
        *   `Progress` "1" -- "1" `Enrollment` (A Progress record belongs to one Enrollment)
    *   **Implementation:** `Enrollment` has `List<Progress> progressRecords;`. `Progress` has an `Enrollment enrollment;` attribute.

*   **`Progress` and `Lesson` (or `ContentItem`):**
    *   **Relationship Type:** Many-to-One Association
    *   **Description:** A `Progress` record is typically associated with a specific `Lesson` or `ContentItem` that the student is making progress on.
    *   **Multiplicity:**
        *   `Progress` "*" -- "1" `Lesson` (Many Progress records can point to the same Lesson, across different students/enrollments)
    *   **Implementation:** `Progress` has a `Lesson lessonTracked;` (or `ContentItem itemTracked;`) attribute.

*   **`Student` and `Submission`:**
    *   **Relationship Type:** One-to-Many Association
    *   **Description:** A `Student` makes many `Submission`s for various `Assessment`s.
    *   **Multiplicity:**
        *   `Student` "1" -- "0..*" `Submission`
    *   **Implementation:** `Student` might have a method `getSubmissions()`. `Submission` has a `Student student;` attribute.

*   **`Assessment` and `Submission`:**
    *   **Relationship Type:** One-to-Many Association
    *   **Description:** An `Assessment` can receive many `Submission`s from different students.
    *   **Multiplicity:**
        *   `Assessment` "1" -- "0..*" `Submission`
    *   **Implementation:** `Assessment` has `List<Submission> submissionsReceived;`. `Submission` has an `Assessment assessment;` attribute.

*   **`Submission` and `Grade`:**
    *   **Relationship Type:** One-to-One Association (A `Submission` has one `Grade`). Or `Grade` can be an attribute of `Submission`. If `Grade` is a separate class (e.g., to store grader comments, grading date), it's a 1-to-1.
    *   **Description:** Each `Submission` results in one `Grade`.
    *   **Multiplicity:**
        *   `Submission` "1" -- "0..1" `Grade` (A Submission might not be graded yet)
    *   **Implementation:** `Submission` has a `Grade grade;` attribute. `Grade` class has a `Submission submission;` attribute if it's a separate class.

*   **`Instructor` and `Submission` (for grading):**
    *   **Relationship Type:** Association
    *   **Description:** An `Instructor` grades `Submission`s. This is more of a behavioral relationship implemented via methods.
    *   **Multiplicity:** Not typically shown as a direct persistent link on the `Instructor` for all submissions, but rather an `Instructor` accesses `Submission`s related to their `Course`'s `Assessment`s.
    *   **Implementation:** `Instructor.gradeSubmission(Submission, ...)` method.

*   **`Course` and `DiscussionForum`:**
    *   **Relationship Type:** One-to-One or One-to-Many Association (A course might have one main forum, or multiple topic-based forums). Let's start with one-to-one for simplicity.
    *   **Description:** A `Course` can have an associated `DiscussionForum`.
    *   **Multiplicity:**
        *   `Course` "1" -- "0..1" `DiscussionForum`
    *   **Implementation:** `Course` has a `DiscussionForum forum;` attribute. `DiscussionForum` might have a `Course course;` attribute.

*   **`DiscussionForum` and `ForumPost`:**
    *   **Relationship Type:** One-to-Many Association (could be Composition if posts don't exist without a forum).
    *   **Description:** A `DiscussionForum` contains many `ForumPost`s.
    *   **Multiplicity:**
        *   `DiscussionForum` "1" -- "0..*" `ForumPost`
    *   **Implementation:** `DiscussionForum` has `List<ForumPost> posts;`. `ForumPost` has a `DiscussionForum forum;` attribute.

*   **`User` (Student/Instructor) and `ForumPost`:**
    *   **Relationship Type:** One-to-Many Association
    *   **Description:** A `User` (acting as author) creates many `ForumPost`s.
    *   **Multiplicity:**
        *   `User` "1" -- "0..*" `ForumPost` (User is the author)
    *   **Implementation:** `ForumPost` has an `User author;` attribute.

*   **`ForumPost` and `ForumPost` (for replies):**
    *   **Relationship Type:** One-to-Many Association (Self-association)
    *   **Description:** A `ForumPost` can have many replies, which are also `ForumPost`s.
    *   **Multiplicity:**
        *   `ForumPost` (parent) "1" -- "0..*" `ForumPost` (replies)
    *   **Implementation:** `ForumPost` has a `ForumPost parentPost;` attribute (null if not a reply) and potentially `List<ForumPost> replies;`.

*   **`User` and `Notification`:**
    *   **Relationship Type:** One-to-Many Association
    *   **Description:** A `User` can receive many `Notification`s.
    *   **Multiplicity:**
        *   `User` "1" -- "0..*" `Notification`
    *   **Implementation:** `User` might have a `List<Notification> notifications;` or a method `getNotifications()`. `Notification` has a `User recipient;` attribute.

---

...(previous content: Object ID table, Attribute/Method tables, General Relationships intro)...

### 3.1 Detailed Whole-Part Relationships: Composition and Aggregation

This subsection focuses on the "whole-part" relationships (Composition and Aggregation) that define structural dependencies and lifecycles within the E-Learning System.

---
#### **Composition Relationships (Strong "is-part-of" / Existential Dependency)**

*In Composition, the "part" object cannot exist independently of the "whole" object. If the "whole" is deleted, the "part" is also deleted. This represents a strong ownership.*

1.  **`Course` and `Module`:**
    *   **Relationship:** `Course` **is composed of** `Module`s.
    *   **Multiplicity:** `Course "1" o-- "1..*" Module`
        *   A `Course` must have at least one `Module` to be meaningful (though this could be `0..*` during initial creation).
        *   A `Module` belongs exclusively to **one** `Course`.
    *   **Rationale & Lifecycle:** `Module`s are integral, structural components of a `Course`. They derive their context and existence from the `Course`. Deleting a `Course` inherently means its constituent `Module`s are also removed from the system.
    *   **Implementation:** `Course` class contains a `List<Module> modules;`. The creation and management of `Module` objects are typically handled through methods within the `Course` class (e.g., `course.addModule(...)`).

2.  **`Module` and `Lesson`:**
    *   **Relationship:** `Module` **is composed of** `Lesson`s.
    *   **Multiplicity:** `Module "1" o-- "1..*" Lesson`
        *   A `Module` must contain at least one `Lesson`.
        *   A `Lesson` belongs exclusively to **one** `Module`.
    *   **Rationale & Lifecycle:** `Lesson`s are the teaching units within a `Module`. Their existence is tied to the `Module` they belong to. Deleting a `Module` implies its `Lesson`s are also deleted.
    *   **Implementation:** `Module` class contains a `List<Lesson> lessons;`. `Lesson` objects are managed via the `Module` class.

3.  **`Lesson` and `ContentItem`:**
    *   **Relationship:** `Lesson` **is composed of** `ContentItem`s.
    *   **Multiplicity:** `Lesson "1" o-- "1..*" ContentItem`
        *   A `Lesson` must contain at least one `ContentItem` (video, quiz, text, etc.) to deliver learning.
        *   A `ContentItem` belongs exclusively to **one** `Lesson`.
    *   **Rationale & Lifecycle:** `ContentItem`s are the actual pieces of learning material. They are defined within the context of a specific `Lesson`. Deleting a `Lesson` means its associated learning materials (`ContentItem`s) are also removed.
    *   **Implementation:** `Lesson` class contains a `List<ContentItem> contentItems;`. `ContentItem`s are managed through `Lesson` methods.

4.  **`Quiz` (a type of `ContentItem`) and `Question`:**
    *   **Relationship:** `Quiz` **is composed of** `Question`s.
    *   **Multiplicity:** `Quiz "1" o-- "1..*" Question`
        *   A `Quiz` must have at least one `Question`.
        *   A `Question` belongs exclusively to **one** `Quiz`.
    *   **Rationale & Lifecycle:** `Question`s are the fundamental components of a `Quiz`. They cannot exist meaningfully outside the context of the `Quiz` they are part of. Deleting a `Quiz` also deletes all its `Question`s.
    *   **Implementation:** `Quiz` class contains a `List<Question> questions;`. `Question` objects are managed via `Quiz` methods.

---
#### **Aggregation Relationships (Weaker "has-a" / Shared or Independent Lifecycle)**

*In Aggregation, the "part" object can exist independently of the "whole" object. If the "whole" is deleted, the "part" may still exist and potentially be associated with another "whole." This represents a weaker ownership or a "uses-a" relationship where the part is shared or has its own lifecycle.*

1.  **`Instructor` and `Course`:**
    *   **Relationship:** `Instructor` **aggregates** (or "manages"/"teaches") `Course`s.
    *   **Multiplicity:**
        *   `Instructor "1" <>-- "0..*" Course` (An Instructor can teach zero or more Courses)
        *   `Course "1" -- "1" Instructor` (A Course is primarily associated with one Instructor. This could be relaxed to many-to-many if co-teaching is a core feature, then it would be a plain association.)
    *   **Rationale & Lifecycle:** An `Instructor` is responsible for creating and teaching `Course`s. However, a `Course` is a significant entity that might persist even if the `Instructor` leaves the platform (e.g., the course could be archived, reassigned to another instructor, or its content made available differently). The `Course`'s lifecycle is not strictly dependent on the `Instructor`'s.
    *   **Implementation:** `Instructor` class has a `List<Course> coursesTaught;`. `Course` class has an `Instructor instructor;` attribute. When an Instructor is removed, logic must decide the fate of their courses (reassign, unpublish, archive).

2.  **`Course` and `DiscussionForum` (Optional Aggregation/Association):**
    *   **Relationship:** `Course` **may have an aggregated** `DiscussionForum`.
    *   **Multiplicity:** `Course "1" <>-- "0..1" DiscussionForum`
    *   **Rationale & Lifecycle:** A `DiscussionForum` can be associated with a `Course` to facilitate student interaction. If the `Course` is deleted, the `DiscussionForum` might be archived or deleted as well, but it's conceivable that forum content might have value or be separable in some scenarios. This is weaker than composition; the forum isn't an *integral structural part* in the same way a Module is. If the forum is *always* deleted with the course and has no other purpose, it leans towards composition. For flexibility, aggregation is a safer initial choice.
    *   **Implementation:** `Course` class has a `DiscussionForum forum;` attribute.

3.  **`User` and `Notification`:**
    *   **Relationship:** `User` **aggregates** `Notification`s.
    *   **Multiplicity:** `User "1" <>-- "0..*" Notification`
    *   **Rationale & Lifecycle:** A `User` receives `Notification`s. While notifications are *for* a user, their lifecycle might be managed independently (e.g., notifications are purged after a certain time, or a user can delete their notifications without affecting their own account). The `Notification` itself doesn't cease to exist if the `User` is (temporarily) inactive. If a User is deleted, their notifications would typically be deleted too (cascade delete), but this is often handled by database constraints rather than strict OOP composition.
    *   **Implementation:** `User` class has a `List<Notification> receivedNotifications;`. `Notification` has a `User recipient;` attribute.

**Note on other relationships previously listed as "Association":**

*   **`Student` and `Enrollment` / `Course` and `Enrollment`:** `Enrollment` is an association class. The link between `Student` and `Enrollment` (or `Course` and `Enrollment`) is a plain association. `Enrollment` itself might be *composed* of `Progress` records if `Progress` cannot exist without a specific `Enrollment`.
    *   **`Enrollment` and `Progress`:** This leans towards **Composition**. `Enrollment "1" o-- "0..*" Progress`. Progress for a specific lesson *within a specific student's enrollment* doesn't make sense if that enrollment is deleted.

*   **`Assessment` and `Submission`:** `Submission` is made *for* an `Assessment` by a `Student`. While a `Submission` is tied to an `Assessment`, it's often treated as a separate record. If an `Assessment` is deleted, existing `Submission`s might be archived or handled according to policy, not necessarily auto-deleted like a composed part. So, this is more of a strong **Association**.

---

...(previous content: Object ID table, Attribute/Method tables, Detailed Relationships)...

## 4. Application of OOP Principles

The design of the E-Learning System leverages fundamental Object-Oriented Programming principles to ensure a robust, maintainable, and scalable architecture.

---
### 4.1 Encapsulation

**Definition:** Encapsulation is the bundling of data (attributes) and the methods that operate on that data within a single unit (a class). It also involves restricting direct access to some of an object's components, which is a key aspect of data hiding.

**Application in E-Learning System:**

*   **Data Hiding:**
    *   Almost all class attributes (e.g., `userID`, `username`, `passwordHash` in `User`; `title`, `description` in `Course`; `questions` in `Quiz`) are declared as `private`.
    *   This prevents direct, uncontrolled modification of an object's state from outside the class. For example, a `Student`'s `enrollmentCount` cannot be arbitrarily changed; it must be managed through methods within the `Student` or `Enrollment` classes.
*   **Controlled Access via Public Methods (Getters/Setters):**
    *   Access to and modification of private attributes are provided through `public` getter and setter methods (e.g., `User.getUsername()`, `Course.setTitle(newTitle)`).
    *   Setters can include validation logic. For instance, `User.setEmail(newEmail)` could validate the email format before updating the attribute. `Quiz.setPassingScorePercentage(score)` can ensure the score is within a valid range (0-100).
*   **Bundling Data and Behavior:**
    *   Each class groups its relevant data and the operations that can be performed on that data. For example, the `Course` class holds course details (`title`, `modules`, `instructor`) and methods to manage it (`addModule()`, `publish()`). A `Quiz` object not only holds `questions` but also the logic to `startAttempt()` and `submitAttempt()`.
*   **Reduced System Complexity:**
    *   By encapsulating details within classes, other parts of the system interact with objects through well-defined interfaces (public methods), without needing to know the internal implementation details. This simplifies understanding and reduces ripple effects when internal changes are made.

---
### 4.2 Abstraction

**Definition:** Abstraction involves hiding complex implementation details and showing only the essential features of an object or system to the user. It focuses on *what* an object does rather than *how* it does it.

**Application in E-Learning System:**

*   **Abstract Classes and Interfaces:**
    *   The `User` class is abstract. External code interacts with `User` objects (which could be `Student`, `Instructor`, or `Admin` instances) through a common interface (e.g., `user.getProfileInfo()`, `user.login()`) without needing to know the specific subclass details for these common operations.
    *   The `ContentItem` class is abstract. A `Lesson` object can manage a list of `ContentItem`s (`List<ContentItem>`). When iterating through this list to display content, the `Lesson` class can call a generic `contentItem.display()` method. The actual display logic is handled by the concrete subclasses (`Video`, `TextDocument`, `Quiz`), hiding their specific implementation details from the `Lesson` class.
*   **Simplified Interfaces:**
    *   Public methods of classes provide an abstract view. For example, `student.enrollInCourse(course)` hides the complexity of creating an `Enrollment` object, updating lists, and potentially checking prerequisites or payment. The caller only needs to know they can enroll a student in a course.
    *   An `Instructor` calling `course.publish()` doesn't need to know the internal steps involved in changing status flags, notifying systems, or updating search indexes.
*   **Focus on Essential Operations:**
    *   Users of a class (other classes or external systems) only interact with the necessary functionalities. For example, when viewing a `Course`, a `Student` primarily cares about `getTitle()`, `getDescription()`, and `getModules()`, not how the `Course` internally stores or orders its `Module`s.

---
### 4.3 Inheritance

**Definition:** Inheritance is a mechanism whereby a new class (subclass or derived class) acquires the properties (attributes and methods) of an existing class (superclass or base class). It promotes code reusability and establishes an "is-a" relationship.

**Application in E-Learning System:**

*   **`User` Hierarchy:**
    *   `Student`, `Instructor`, and `Administrator` classes **inherit from** the `User` abstract class.
    *   They share common attributes like `userID`, `username`, `email`, `passwordHash`, and methods like `login()`, `updateProfileDetails()`. This avoids redundant code in each subclass.
    *   Each subclass then adds its specific attributes and methods (e.g., `Student` has `enrolledCourses`, `Instructor` has `coursesTaught` and `createCourse()`).
*   **`ContentItem` Hierarchy:**
    *   `Video`, `TextDocument`, `Quiz`, and `AssignmentLink` classes **inherit from** the `ContentItem` abstract class.
    *   They share common attributes like `contentID` and `title`.
    *   Each subclass provides a concrete implementation for abstract methods like `display()` and may add specific attributes (e.g., `Video` has `videoURL`, `Quiz` has `questions`).
*   **Code Reusability:** Common functionalities defined in superclasses are readily available to subclasses, reducing development effort and improving consistency.
*   **Hierarchical Classification:** Inheritance helps in organizing classes into a logical hierarchy, reflecting real-world relationships and making the system easier to understand.

---
### 4.4 Polymorphism

**Definition:** Polymorphism ("many forms") allows objects of different classes to be treated as objects of a common superclass. It is often achieved through method overriding (where a subclass provides a specific implementation of a method defined in its superclass) and method overloading (where multiple methods have the same name but different parameters).

**Application in E-Learning System:**

*   **Treating Different User Types Uniformly:**
    *   A list or array of `User` objects can hold instances of `Student`, `Instructor`, or `Administrator`. Common operations like `user.getProfileInfo()` can be called on any object in the list, and the specific version of the method (if overridden) will be executed.
*   **Handling Diverse `ContentItem`s:**
    *   A `Lesson` object contains a `List<ContentItem>`. When a `Lesson` needs to display its content, it can iterate through this list and call `item.display()` on each `ContentItem`.
    *   The actual `display()` method executed will depend on the runtime type of the `item` (i.e., `Video.display()`, `TextDocument.display()`, or `Quiz.display()`). This allows the `Lesson` class to manage content display without needing to know the specific type of each content item, making the `Lesson` class highly extensible to new content types.
*   **Method Overriding:**
    *   The `display()` method in `ContentItem` is abstract and is overridden by concrete subclasses (`Video`, `TextDocument`, `Quiz`) to provide specific display logic.
    *   The `User` class might have a virtual method like `getDashboardElements()` which is overridden by `Student`, `Instructor`, and `Admin` to return role-specific dashboard items.
*   **Flexibility and Extensibility:**
    *   Polymorphism makes the system more flexible. New types of `User`s or `ContentItem`s can be added with minimal changes to the existing code that uses the superclass types. For example, if a new `InteractiveSimulation` content type is added (extending `ContentItem`), the `Lesson` class can still display it without modification, as long as `InteractiveSimulation` implements the `display()` method.

---
