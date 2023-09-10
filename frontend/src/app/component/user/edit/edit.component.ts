import {Component, Input} from '@angular/core';
import {UserService} from "../../../service/user.service";
import {User} from "../../../domain/model/User";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent {

  @Input('user') user: User

  constructor(
    private userService: UserService,
    private router: Router
  ) {
  }

  deleteAccount() {
    this.userService.delete(this.user.id)
      .subscribe(res => {
          console.log(res)
          this.router.navigate(['/home'])
        }
      )
  }


}
