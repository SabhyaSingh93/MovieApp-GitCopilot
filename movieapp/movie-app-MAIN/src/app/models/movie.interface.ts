
// create interface for Imovie using  {
//"rank": 32,
 // "title": "Oppenheimer",
 // "thumbnail": "https://m.media-amazon.com/images/M/MV5BMDBmYTZjNjUtN2M1MS00MTQ2LTk2ODgtNzc2M2QyZGE5NTVjXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1
//  _UY67_CR0,0,45,67_AL_.jpg",
  //"rating": "8.6",
 // "id": "top32",
 // "year": 2023,
//  "image": "https://m.media-amazon.com/images/M/MV5BMDBmYTZjNjUtN2M1MS00MTQ2LTk2ODgtNzc2M2QyZGE5NTVjXkEyXkFqcGdeQXVyNzAwMjU2MTY@._V1
//_QL75_UX380_CR0,0,380,562_.jpg",
 // "description": "The story of American scientist, J. Robert Oppenheimer, and his role in the development of the atomic bomb.",
//  "trailer": "https://www.youtube.com/watch?v=uYPbbksJxIg",
//  "trailer_embed_link": "https://www.youtube.com/embed/uYPbbksJxIg",
//  "director": [
 //   "Christopher Nolan"
 // ],
 // "writers": [
 //   "Christopher Nolan",
 //   "Kai Bird",
  //  "Martin Sherwin"
 // ],
  //"imdbid": "tt15398776",
 // "imdb_link": "https://www.imdb.com/title/tt15398776"  }

/**
 * Represents an movie.
 */
export interface IMovie {
    /**
     * The unique identifier of the movie.
     */
    id: number;
   title:string;
   thumbnail:string;
    url: string;
    trailer:string;
    image: string;
    imdbid:string;
    imdb_link: string;
}

