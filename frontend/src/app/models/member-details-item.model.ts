import {RepoDetailsItemModel} from "./repo-details-item.model";

export interface MemberDetailsItemModel{

  id: number;
  username: string;
  name: string;
  createdAt: string;
  avatarUrl: string;
  repoDetailsItemList: RepoDetailsItemModel[];

}
