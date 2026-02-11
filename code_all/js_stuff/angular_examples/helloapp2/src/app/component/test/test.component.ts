import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [FormsModule],
  template: `
    First no: <input [(ngModel)] ='num1' type="number" name="num1"/><br/>
    Second no: <input [(ngModel)] ='num2' type="number" name="num2"/><br/>
    <button  (click) = 'addition()'>Calculate</button>
   
	{{num1}} + {{num2}}={{result}}
  `,
  styles: ``
})
export class TestComponent {
  public num1: number = 0;
  public num2: number = 0;
  public result: number = 0;

  addition() {
    this.result = this.num1 + this.num2;
  }
}
