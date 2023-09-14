import {SocialAccountLinkType} from "../enum/SocialAccountLinkType";
import {JsonProperty} from "json2typescript";

export class SocialAccountLink {
  id: number;
  type: SocialAccountLinkType;
  value: string;

  @JsonProperty('user_id', Number)
  userId: number;
}
