import { Component } from '@angular/core';

export class Hero {
	id: number;
	name: string;
}

@Component({
	template: `
	<h1>{{title}}</h1>
	<h2>ID: {{hero.id}}</h2>
	<h2>{{hero.name}} details!</h2>
	<div>
		<label>id: </label>
		<input [(ngModel)]="hero.id" placeholder="id">
	</div>
	<div>
		<label>name: </label>
		<input [(ngModel)]="hero.name" placeholder="name">
	</div>
	`,
	styles: [`
    h1 {
      margin-top: 30px;
      color: #B6124A;
    }
    h2 {
      text-decoration: underline;
      text-decoration-color: #B6124A;
    }
    label {
    	font-size: 18px;
    }
    input {
      margin-top: 15px;
      border: 1px solid #B6124A;
      border-radius: 5px;
    }
    input:focus {
      border-color: #B6124A;
    }
  `],
})
export class AppComponent {
	hero: Hero = {
		id: 1,
		name: 'Windstorm'
	};
	title = 'Tour of Heroes';
}
