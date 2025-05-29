# Domain Solution: Social Media Platform

## Overview

This solution models a Social Media Platform using Object-Oriented Principles. It focuses on representing core entities such as users, posts, comments, likes, and relationships through well-defined classes. The design separates concerns, encapsulates responsibilities, and supports scalable interactions like posting, liking, following, and real-time notifications.

## Core Classes

### 1. User Class

Represents a registered user on the platform.

**Attributes:**

| Name        | Data Type        | Visibility | Rationale                                                |
|-------------|------------------|------------|-----------------------------------------------------------|
| `userId`    | String            | `private`  | Unique identifier for the user.                          |
| `name`      | String            | `private`  | Full name or display name.                               |
| `email`     | String            | `private`  | User's email (used for login or communication).          |
| `password`  | String            | `private`  | Encrypted password for authentication.                   |
| `bio`       | String            | `private`  | Optional user bio for profile.                           |
| `followers` | List<User>        | `private`  | Users who follow this user.                              |
| `following` | List<User>        | `private`  | Users this user follows.                                 |
| `posts`     | List<Post>        | `private`  | Posts made by the user.                                  |

**Methods:**

| Name                | Parameters            | Return Type   | Visibility | Rationale                                       |
|---------------------|------------------------|---------------|------------|-------------------------------------------------|
| `User(...)`         | (initial values)       | constructor   | `public`   | Constructs a user with attributes.              |
| `follow()`          | target: User           | void          | `public`   | Follows another user.                           |
| `unfollow()`        | target: User           | void          | `public`   | Unfollows another user.                         |
| `addPost()`         | post: Post             | void          | `public`   | Adds a post to this user’s feed.                |
| `getFollowers()`    | -                      | List<User>    | `public`   | Returns all followers.                          |
| `getFollowing()`    | -                      | List<User>    | `public`   | Returns all followed users.                     |

---

### 2. Post Class

Represents a piece of content posted by a user.

**Attributes:**

| Name        | Data Type     | Visibility | Rationale                                             |
|-------------|---------------|------------|--------------------------------------------------------|
| `postId`    | String         | `private`  | Unique identifier for the post.                       |
| `author`    | User           | `private`  | User who created the post.                            |
| `content`   | String         | `private`  | Text or media content of the post.                    |
| `timestamp` | Date           | `private`  | Time of creation.                                     |
| `likes`     | List<Like>     | `private`  | Users who liked the post.                             |
| `comments`  | List<Comment>  | `private`  | Comments associated with this post.                   |

**Methods:**

| Name              | Parameters          | Return Type     | Visibility | Rationale                                     |
|-------------------|----------------------|------------------|------------|-----------------------------------------------|
| `Post(...)`       | (initial values)     | constructor      | `public`   | Creates a new post.                           |
| `addLike()`       | like: Like           | void             | `public`   | Adds a like to the post.                      |
| `removeLike()`    | user: User           | void             | `public`   | Removes a like from the post by user.         |
| `addComment()`    | comment: Comment     | void             | `public`   | Adds a comment to the post.                   |
| `getCommentCount()`| -                   | int              | `public`   | Returns the number of comments.               |

---

### 3. Comment Class

Represents a comment made on a post.

**Attributes:**

| Name        | Data Type | Visibility | Rationale                                      |
|-------------|-----------|------------|------------------------------------------------|
| `commentId` | String    | `private`  | Unique identifier for the comment.            |
| `author`    | User      | `private`  | User who wrote the comment.                   |
| `post`      | Post      | `private`  | The post the comment belongs to.              |
| `text`      | String    | `private`  | The content of the comment.                   |
| `timestamp` | Date      | `private`  | Time the comment was made.                    |

**Methods:**

| Name              | Parameters     | Return Type | Visibility | Rationale                            |
|-------------------|----------------|-------------|------------|--------------------------------------|
| `Comment(...)`    | values         | constructor | `public`   | Creates a new comment.               |
| `editComment()`   | newText: String| void        | `public`   | Edits the content of the comment.    |

---

### 4. Like Class

Represents a “like” on a post.

**Attributes:**

| Name      | Data Type | Visibility | Rationale                                |
|-----------|-----------|------------|-------------------------------------------|
| `likeId`  | String    | `private`  | Unique identifier for the like.           |
| `user`    | User      | `private`  | User who liked the post.                  |
| `post`    | Post      | `private`  | The post that was liked.                  |

**Methods:**

| Name         | Parameters | Return Type | Visibility | Rationale                     |
|--------------|------------|-------------|------------|-------------------------------|
| `Like(...)`  | values     | constructor | `public`   | Creates a new like record.    |

---

### 5. Notification Class

Represents in-app notifications.

**Attributes:**

| Name         | Data Type | Visibility | Rationale                                      |
|--------------|-----------|------------|-----------------------------------------------|
| `notificationId` | String | `private`  | Unique identifier for the notification.        |
| `recipient`  | User      | `private`  | The user receiving the notification.           |
| `message`    | String    | `private`  | The text/message of the notification.          |
| `createdAt`  | Date      | `private`  | Time the notification was created.             |
| `isRead`     | boolean   | `private`  | Flag for read/unread status.                   |

**Methods:**

| Name              | Parameters | Return Type | Visibility | Rationale                    |
|-------------------|------------|-------------|------------|-------------------------------|
| `markAsRead()`    | -          | void        | `public`   | Marks the notification read. |

---

### 6. AuthManager Class

Handles user registration and login.

**Methods:**

| Name           | Parameters                      | Return Type | Visibility | Rationale                          |
|----------------|----------------------------------|-------------|------------|-------------------------------------|
| `register()`   | name, email, password           | User        | `public`   | Registers a new user.              |
| `login()`      | email, password                 | User        | `public`   | Authenticates and returns a user.  |
| `logout()`     | user: User                      | void        | `public`   | Ends user session.                 |

---

### 7. FeedManager Class

Assembles the news feed for a user.

**Methods:**

| Name           | Parameters    | Return Type  | Visibility | Rationale                             |
|----------------|---------------|--------------|------------|----------------------------------------|
| `getFeed()`    | user: User    | List<Post>   | `public`   | Retrieves posts from followed users.   |

---

### 8. ProfileManager Class

Handles user profile settings.

**Methods:**

| Name                 | Parameters                     | Return Type | Visibility | Rationale                             |
|----------------------|--------------------------------|-------------|------------|----------------------------------------|
| `updateProfile()`    | user, new values               | void        | `public`   | Updates user profile details.          |
| `setPrivacySettings()`| user, new settings            | void        | `public`   | Modifies account visibility settings.  |

---

## Notes

- Relationships like `User → Post`, `Post → Comment`, and `Post → Like` are core associations.
- Data types like `Date` assume Java or JavaScript-based implementation.
- Notification and FeedManager logic could later integrate real-time updates using WebSockets or Firebase.

