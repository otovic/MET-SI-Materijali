

class Vehicle {
    constructor(wheels, fuel) {
        this.wheels = wheels;
        this.fuel = fuel;
    }

    calculateSpeed(distance, time) {
        return distance / time;
    }

    static getInfo(vehicle) {
        return "Vehicle with " + vehicle.wheels + " wheels and " + vehicle.fuel + "l of fuel";
    }
}


class SportsCar extends Vehicle {
    constructor(wheels, fuel, horsepower) {
        super(wheels, fuel);
        this.horsepower = horsepower;
    }

    calculateAcceleration(time) {
        return this.horsepower / time;
    }

    toString(time) {
        return ", horsepower: " + this.calculateAcceleration(time);
    }
}

class Van extends Vehicle {
    constructor(wheels, fuel, seats) {
        super(wheels, fuel);
        this.seats = seats;
    }

    toString() {
        return ", seats: " + this.seats;
    }
}

console.log("VEHICLES");
const vehicle1 = new Vehicle(4, 45);
const vehicle2 = new Vehicle(4, 55);
const vehicle3 = new Vehicle(4, 65);
console.log(vehicle1.calculateSpeed(100, 2));
console.log(vehicle2.calculateSpeed(150, 2));
console.log(vehicle3.calculateSpeed(200, 2));
var vehicleMap = new Map();
vehicleMap.set(1, vehicle1);
vehicleMap.set(2, vehicle2);
vehicleMap.set(3, vehicle3);

console.log("SPORTS CAR");
const sportsCar1 = new SportsCar(4, 55, 500);
console.log(sportsCar1.calculateSpeed(200, 4));
const sportsCar2 = new SportsCar(4, 70, 650);
console.log(sportsCar2.calculateSpeed(250, 4));
const sportsCar3 = new SportsCar(4, 90, 450);
console.log(sportsCar3.calculateSpeed(180, 4));
var sportMap = new Map();
sportMap.set(1, sportsCar1);
sportMap.set(2, sportsCar2);
sportMap.set(3, sportsCar3);

console.log("VANS");
const van1 = new Van(4, 66, 7);
console.log(van1.calculateSpeed(80, 2));
const van2 = new Van(4, 66, 7);
console.log(van2.calculateSpeed(80, 2));
const van3 = new Van(4, 66, 7);
console.log(van3.calculateSpeed(80, 2));
var vanMap = new Map();
vanMap.set(1, van1);
vanMap.set(2, van2);
vanMap.set(3, van3);


var listMap = new Map();
var list1 = document.createElement("ol");
vehicleMap.forEach(function (value, key) {
    var listItem1 = document.createElement("li");
    listItem1.textContent = Vehicle.getInfo(value);
    list1.appendChild(listItem1);

});

var list2 = document.createElement("ol");
sportMap.forEach(function (value, key) {
    var listItem2 = document.createElement("li");
    listItem2.textContent = Vehicle.getInfo(value) + value.toString();
    list2.appendChild(listItem2);
});


var list3 = document.createElement("ol");
vanMap.forEach(function (value, key) {
    var listItem3 = document.createElement("li");
    listItem3.textContent = Vehicle.getInfo(value) + value.toString();
    list3.appendChild(listItem3);
});

listMap.set("vehicles", list1);
listMap.set("sports car", list2);
listMap.set("van", list3);

function showList() {
    var dropdown = document.getElementById("dropdown");
    var selectedValue = dropdown.options[dropdown.selectedIndex].value;

    var listContainer = document.getElementById("listContainer");
    listContainer.innerHTML = "";
    var myList = listMap.get(selectedValue);
    listContainer.appendChild(myList);
}

function changeItem() {
    var dropdown = document.getElementById("dropdown");
    var selectedValue = dropdown.options[dropdown.selectedIndex].value;

    var listContainer = document.getElementById("listContainer");
    var lists = listContainer.getElementsByTagName("ol");
    userInput = prompt("Enter a number to change:");
    var number = parseInt(userInput);
    var f = prompt("Enter fuel");
    var fuel = parseInt(f);
    var items = lists[0].querySelectorAll("li");
    var listItemToChange = items[number - 1];
    var newText = "";
    if (selectedValue == "vehicles") {
        vehicleMap.get(number).fuel = fuel;
        var temp1 = vehicleMap.get(number);
        newText = temp1.getInfo(temp1);
    }
    else if (selectedValue == "sport") {
        sportMap.get(number).fuel = fuel;
        var temp2 = sportMap.get(number);
        newText = temp1.getInfo(temp2) + temp2.toString(2);
    } else {
        vanMap.get(number).fuel = fuel;
        var temp3 = vanMap.get(number);
        newText = temp1.getInfo(temp3) + temp3.toString();
    }
    listItemToChange.textContent = newText;
    console.log("item changed");
}

function removeItem() {
    var dropdown = document.getElementById("dropdown");


    var listContainer = document.getElementById("listContainer");
    var lists = listContainer.getElementsByTagName("ol");

    var userInput = prompt("Enter a number to remove:");
    var number = parseInt(userInput);
    var items = lists[0].querySelectorAll("li");

    var listItemToRemove = items[number - 1];

    lists[0].removeChild(listItemToRemove);

    if (selectedValue == "vehicles") {
        vehicleMap.delete(number);
    }
    else if (selectedValue == "sport") {
        sportMap.delete(number);
    } else {
        vanMap.delete(number);
    }
    console.log("item removed");
}
