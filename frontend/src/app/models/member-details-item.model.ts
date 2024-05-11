import {RepoDetailsItemModel} from "./repo-details-item.model";

export interface MemberDetailsItemModel{

  id: number;
  username: string;
  avatarUrl: string;
  repoDetailsItemList: RepoDetailsItemModel[];

}
