title: Task
controls: true
theme: sudodoki/reveal-cleaver-theme

--

# Task Lifecycle

A typical project has

*   story
*   bug
*   spike

Now, write a small program to simulate lifecycle of project management tool.

---

## Step 1

Identify various attributes and behavior for `story`

```java
public class Story {
  ...
}
```

---

## Story

A typical `story` will have a `number`, `title`, `description`, `iteration`, `assignedTo`

```java
public class Story {
  long number;
  String title;
  String description;
  String iteration;
  String assignedTo;
  ...
}
```

---

## Step 2

Identify various attributes and behavior for `bug`

```java
public class Bug {
  ...
}
```

---

## Bug

A typical `bug` will have a `number`, `title`, `description`, `iteration`, `assignedTo`

```java
public class Bug {
  long number;
  String title;
  String description;
  String iteration;
  String assignedTo;
  ...
}
```

---

## Step 3

Identify various attributes and behavior for `spike`

> A typical `spike` is similar to a story but used for feasibility analysis.

```java
public class Spike {
  ...
}
```

---

## Spike

A typical `spike` will have a `number`, `title`, `description`, `iteration`, `assignedTo`

```java
public class Spike {
  long number;
  String title;
  String description;
  String iteration;
  String assignedTo;
  ...
}
```

---

## Step 4

Create a project, add a `story`, `bug` & `spike` task to it, play & close them.

```java
public class Project {
  String name;
  ...
  public void add(...) {
  }

  public void play(...) {
  }

  public void close(...) {
  }
}
```

---

## Step 5

A Story can be closed only if it is small and it's iteration start and iteration close/end are the same
