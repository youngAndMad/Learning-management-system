import {SocialAccountLink} from "./SocialAccountLink";

export interface User {
  id: number
  name: string
  surname: string
  email: string
  socialAccountLinks: Array<SocialAccountLink>
}
