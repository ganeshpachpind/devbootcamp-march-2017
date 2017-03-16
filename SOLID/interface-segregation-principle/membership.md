title: Membership
controls: true
theme: sudodoki/reveal-cleaver-theme

--

# User Management

Write a small program for user membership, such as:

*   login
*   logout
*   register
*   forgot password

> `membership`: the fact of being a member of a group.

---

## Step 1

Add a behavior to register

```java
public class LocalMembership {
  public UUID register(User user){
    ...
  }
}
```

---

## Step 2

Add a behavior to login

```java
public class LocalMembership {
  public boolean login(User user){
    ...
  }
}
```

---

## Step 3

Add a behavior to logout

```java
public class LocalMembership {
  public void logout(User user){
    ...
  }
}
```

---

## Step 4

Add a behavior to recover password

```java
public class LocalMembership {
  public void forgotPassword(User user){
    ...
  }
}
```

---

## Step 5

How do you modify your program to use third party authentication such as `OAuth` for login and logout?

```java
public class OAuthMemmbership {
  ...
}
```
