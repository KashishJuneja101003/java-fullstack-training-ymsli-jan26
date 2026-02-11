import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dept-detail',
  standalone: true,
  imports: [],
  template: `
       <h3>you selected dept with id {{deptId}}</h3>
  `,
  styles: ``
})
export class DeptDetailComponent {
   public deptId: any; 

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    // tslint:disable-next-line: radix
    let id = parseInt(this.route.snapshot.paramMap.get('id') ?? '0');
    this.deptId = id;
  }

}
