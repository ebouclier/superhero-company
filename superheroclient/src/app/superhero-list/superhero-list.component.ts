import { Component, OnInit } from '@angular/core';
import { SuperheroService } from '../shared/superhero/superhero.service';
import { GiphyService } from '../shared/giphy/giphy.service';

@Component({
  selector: 'app-superhero-list',
  templateUrl: './superhero-list.component.html',
  styleUrls: ['./superhero-list.component.css']
})
export class SuperheroListComponent implements OnInit {
  superheros : Array<any>;

  constructor(private superheroservice : SuperheroService, private giphyservice : GiphyService) { }

  ngOnInit() {
    this.superheroservice.getAll().subscribe(data => {
      this.superheros = data;
      for (const superhero of this.superheros) {
        this.giphyservice.get(superhero.superHeroName).subscribe(url => superhero.giphyUrl = url);
      }
    })
  }

}
