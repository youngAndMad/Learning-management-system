import {Component, Input} from '@angular/core';
import {UserService} from "../../../service/user.service";
import {User} from "../../../domain/model/User";
import {Router} from "@angular/router";
import {SocialAccountLinkService} from "../../../service/social-account-link.service";
import {SocialAccountLinkType} from "../../../domain/enum/SocialAccountLinkType";
import {FormBuilder, FormGroup} from "@angular/forms";
import {validateLink} from "../../../utils/Validator";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent {

  @Input('user') user: User
  protected readonly SocialAccountLinkType = SocialAccountLinkType;
  socialLinksForm: FormGroup

  constructor(
    private userService: UserService,
    private router: Router,
    private socialAccountLinkService: SocialAccountLinkService,
    private fb: FormBuilder
  ) {
    this.socialLinksForm = this.fb.group({
      githubLink: ['', validateLink(SocialAccountLinkType.GITHUB)],
      twitterLink: ['', validateLink(SocialAccountLinkType.TWITTER)],
      linkedinLink: ['', validateLink(SocialAccountLinkType.LINKEDIN)],
    });
  }

  deleteAccount() {
    this.userService.delete(this.user.id)
      .subscribe(res => {
          this.router.navigate(['/home'])
            .then(() => console.log('redirecting to home page'))
        }
      )
  }

  deleteSocialAccountLink(id: number) {
    this.socialAccountLinkService.delete(id)
      .subscribe(res => console.log(res))
  }

  findLink(type: SocialAccountLinkType) {
    return this.user.socialAccountLinks
      .find(l => l.type === type)
  }

  submit() {
    this.submitSocialLink('githubLink' , SocialAccountLinkType.GITHUB)
    this.submitSocialLink('twitterLink' , SocialAccountLinkType.TWITTER)
    this.submitSocialLink('linkedinLink' , SocialAccountLinkType.LINKEDIN)
  }

  private submitSocialLink(controlName: string, linkType: SocialAccountLinkType) {
    const link = this.socialLinksForm.get(controlName)?.value;
    if (link) {
      this.socialAccountLinkService.manage({
        type: linkType,
        link: link,
      });
    }
  }

}
