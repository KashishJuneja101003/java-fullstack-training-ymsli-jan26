import { Routes } from '@angular/router';
import { DeptlistComponent } from './deptlist/deptlist.component';
import { EmplistComponent } from './emplist/emplist.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DeptDetailComponent } from './dept-detail/dept-detail.component';

export const routes: Routes = [
    { path: '', redirectTo: '/departments', pathMatch: 'full' }, // default
    { path: 'departments', component: DeptlistComponent },
    { path : 'departments/:id', component: DeptDetailComponent},
    { path: 'employees', component: EmplistComponent },
    { path: '**', component: PageNotFoundComponent } // wildcard
];
