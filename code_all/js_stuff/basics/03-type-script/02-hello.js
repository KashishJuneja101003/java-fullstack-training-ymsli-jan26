// function  greet(person:string) {
//     return "Hello, " + person;
// }
// console.log(greet("121"))
var isValid = true;
var rollNumber = 545;
// let data: number | string="545";
// let data: any='abc';
// let i: number;
// let count: Array<number> = [1,2,3,4];
// for(i of count){
//     console.log(i)
// }
// function greet(name: string): string {
//     return `hello ${name}`;
// }
// console.log(greet('raj'))
// let joyStStatus = 1;
// enum Directions { UP, DOWN, LEFT, RIGHT };
// if(joyStStatus==Directions.DOWN){
// }
// interface Person {
//     firstName: string;
//     lastName: string;
// }
// let customer: Person = { 
//    firstName: "ravi",
//    lastName: "kumar", 
// } 
// function hello(person: Person) :Person {
//    return customer;
// }
// interface Person { 
//    age: number 
// } 
// interface Musician extends Person { 
//    instrument: string 
// } 
// let drummer = <Musician>{}; 
// drummer.age
var Car = /** @class */ (function () {
    function Car(engine) {
        this.engine = engine;
    }
    Car.prototype.disp = function () {
        console.log("Function displays Engine is: " + this.engine);
    };
    return Car;
}());
var c = new Car('v8');
c.disp();
