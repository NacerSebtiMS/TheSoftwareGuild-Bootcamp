import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProjectsHomeComponent } from './projects-home/projects-home.component';

const routes: Routes = [
  { path: 'projects', component: ProjectsHomeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectsRoutingModule { }
