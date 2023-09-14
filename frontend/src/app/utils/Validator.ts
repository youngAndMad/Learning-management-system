import {AbstractControl, ValidationErrors, ValidatorFn} from '@angular/forms';
import {SocialAccountLinkType} from "../domain/enum/SocialAccountLinkType";

export function validateLink(type: SocialAccountLinkType): ValidatorFn {

  return (control: AbstractControl): ValidationErrors | null => {
    const value = control.value;

    if (!value) {
      return null;
    }

    let isValid: boolean = false;

    switch (type) {
      case SocialAccountLinkType.TWITTER:
        isValid = value.startsWith("https://twitter.com/");
        break;

      case SocialAccountLinkType.GITHUB:
        isValid = value.startsWith("https://github.com/");
        break;

      case SocialAccountLinkType.LINKEDIN:
        isValid = value.startsWith("https://www.linkedin.com/");
        break;

      default:
        break;
    }

    return isValid ? null : {invalidLink: true};
  };
}

