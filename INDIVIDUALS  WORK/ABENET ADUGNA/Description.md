# Domain Description: Social Media Platform

This project focuses on developing a Social Media Platform where users can create profiles, post content, interact with others, and manage privacy settings. The system supports core social features such as following users, liking posts, commenting, notifications, and real-time updates.

## Key Functionalities Required

1. **User Profile Management**
   - Allow users to register, log in, and manage profile details.
   - Profile includes name, bio, email, password, and privacy settings.
   - Users can update or delete their profile.

2. **Post Creation & Interaction**
   - Users can create, edit, or delete posts (text, image, or media).
   - View a feed of posts from followed users or public profiles.
   - Posts include timestamps, captions, and visibility options.

3. **Like and Comment System**
   - Users can like or comment on posts.
   - Each post shows the number of likes and a list of comments.
   - Comments may be deleted or edited by their authors.

4. **Following and Followers**
   - Users can follow or unfollow other users.
   - View followers and following lists.
   - Suggest friends or accounts to follow.

5. **Notification System**
   - Notify users when they get a new like, comment, follower, or mention.
   - Notifications can be marked as read or dismissed.

6. **Search and Explore**
   - Allow users to search for other users or hashtags.
   - Explore trending posts or accounts.

7. **Real-Time Updates (Optional)**
   - Use sockets or polling to support live notifications and feed updates.

## System Characteristics

* **Scalability:** Should support many users, posts, and real-time updates.
* **Security:** Secure password handling, privacy settings, and access controls.
* **Responsiveness:** Fast and intuitive user interface for both desktop and mobile.

## Initial Object Identification Table: Social Media Platform

| Object/Class Name     | Type             | Visibility | Rationale / Responsibility                                                                   |
|------------------------|------------------|------------|----------------------------------------------------------------------------------------------|
| **User**              | Class             | `public`   | Represents a registered user with profile data, credentials, and relationships.              |
| **Post**              | Class             | `public`   | Stores user-generated content with timestamps, content, likes, and comments.                |
| **Comment**           | Class             | `public`   | Represents a user's response to a post, linked to the user and the target post.              |
| **Like**              | Class             | `public`   | Captures which user liked which post.                                                        |
| **Follow**            | Class             | `public`   | Represents the follower-following relationship between users.                               |
| **Notification**      | Class             | `public`   | Holds event-driven updates such as likes, follows, or comments.                             |
| **FeedManager**       | Controller Class  | `public`   | Handles retrieval and assembly of the user’s news feed.                                      |
| **AuthManager**       | Controller Class  | `public`   | Manages login, registration, and authentication flow.                                       |
| **ProfileManager**    | Controller Class  | `public`   | Manages profile updates, visibility settings, and deletion.                                  |
| **SearchService**     | Class             | `public`   | Enables user or post searching based on keywords or hashtags.                               |
| **PrivacySettings**   | Class             | `public`   | Defines visibility options and controls who can see user content.                            |

