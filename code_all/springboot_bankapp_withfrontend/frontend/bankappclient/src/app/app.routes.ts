import { Routes } from '@angular/router';
import { AccountListComponent } from './components/account-list/account-list.component';

export const routes: Routes = [
  { path: 'accounts', component: AccountListComponent },
  { path: '', redirectTo: 'accounts', pathMatch: 'full' }
];