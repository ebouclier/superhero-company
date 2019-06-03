import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class GiphyService {

  giphyApi = '//api.giphy.com/v1/gifs/search?api_key=QWUA3KtO5TaopFNuYuCl5PWIP0O6FKeR';

  constructor(public http: HttpClient) {
  }

  get(searchTerm) {
    const apiLink = this.giphyApi + "&q=" + searchTerm + "&limit=25&offset=0&rating=G&lang=en";
    return this.http.get(apiLink).pipe(map((response: any) => {
      if (response.data.length > 0) {
        return response.data[0].images.original.url;
      } else {
        return 'https://media.giphy.com/media/YaOxRsmrv9IeA/giphy.gif';
      }
    }));
  }
}