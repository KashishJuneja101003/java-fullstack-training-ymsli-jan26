import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deptlist',
  standalone: true,
  imports: [CommonModule],
  template: `

   <ul class="item">
	  <li (click)="onSelect(department)"  *ngFor="let department of departments">
		<span class="badge">{{department.id}}</span> {{department.name}}
	  </li>
	</ul>
  `,
  styles: ``
})
export class DeptlistComponent {
  public departments = [
    {"id": 1, "name": "Angular"},
    {"id": 2, "name": "Node"},
    {"id": 3, "name": "MongoDB"},
    {"id": 4, "name": "Ruby"},
    {"id": 5, "name": "Bootstrap"}
  ]
  constructor(private router: Router) { }

    onSelect(department: { id: any; }){
    // from neviate from code to rooute we need router service
    this.router.navigate(['/departments', department.id]);
  }
}
