import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TestComponent } from "./component/test/test.component";
import { EmpComponent } from "./component/emp/emp.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, EmpComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  triningTeam: string = 'ymsli traning';
}
