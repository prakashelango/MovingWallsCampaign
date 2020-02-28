import {RouterModule, Routes} from '@angular/router';

import {LoginComponent} from './login';
import {AuthGuard} from './_helpers';
import {SidenavComponent} from "./sidenav/sidenav.component";

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'home', component: SidenavComponent, canActivate: [AuthGuard]},

  // otherwise redirect to home
  {path: '**', redirectTo: ''}
];

export const appRoutingModule = RouterModule.forRoot(routes);
