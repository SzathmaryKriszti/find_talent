import {RepoDetailsItemModel} from "./repo-details-item.model";

export interface MemberDetailsItemModel{

  id: number;
  username: string;
  name: string;
  location: string;
  email: string;
  bio: string;
  createdAt: string;
  avatarUrl: string;
  repoDetailsItemList: RepoDetailsItemModel[];

}
