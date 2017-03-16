title: Cashier
controls: true
theme: sudodoki/reveal-cleaver-theme

--

# Cashier

Write a small program to help the cashier to generate receipt for the list of items

---

## Step 1

Create a class to hold product information

```java
public class XXX {
    String name;
    String description;
    int measure;
    float price;
    String unit;
}
```

---

## Step 2

Add ability to specify multiple quantities for a product

---

## Step 3

```java
public class YYY {
    Product product;
    int quantity;
}
```

---

## Step 4

Add ability to generate total price

```java
public class ZZZ {
    private List<Item> items;
    public float total(){
        ---
    }
}
```

---

## Step 5

```java
public class Item {
    Product product;
    int quantity;

    public float total() {
        return product.getPrice() * quantity;
    }
}
```


---

## Step 6

Generate receipt for the order to print the total amount.
