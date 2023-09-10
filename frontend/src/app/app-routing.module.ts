import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProfileComponent} from "./component/user/profile/profile.component";
import {EditComponent} from "./component/user/edit/edit.component";

const routes: Routes = [
  {
    path: 'profile', component: ProfileComponent
  },
  {
    path: 'profile/edit', component: EditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
