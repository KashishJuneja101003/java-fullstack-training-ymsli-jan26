// function  greet(person:string) {
//     return "Hello, " + person;
// }

// console.log(greet("121"))
let isValid: boolean=true;
let rollNumber: number=545;

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

class Car{
    engine: string;
    constructor(engine: string){
         this.engine = engine;
    }
    
    disp(): void { 
      console.log("Function displays Engine is: " + this.engine); 
   } 
}

let c=new Car('v8')
c.disp();






