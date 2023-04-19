import './App.css';
import {Component} from "react";
import React from "react";
import {Navigate, Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Authors from "../Authors/authors";
import Categories from "../Categories/categories";
import authors from "../Authors/authors";
import booksRepository from "../../repository/booksRepository";
import BooksRepository from "../../repository/booksRepository";
import BooksService from "../../repository/booksRepository";
import Countries from "../Countries/countries";
import Books from "../Books/books";
import BookAdd from "../Books/BookAdd/bookAdd";
import Header from "../Header/header";

// function App() {
//   return (
//       <div>
//         <h1>EMT Labs 2023</h1>
//       </div>
//   );
// }

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authors: [],
            categories: [],
            countries: [],
            books: [],
        };
    }

    componentDidMount() {
        this.loadAuthors()
        this.loadCategories();
        this.loadCountries();
        this.loadBooks();
    }

    render() {
        return(
            <div>
                {/*<Books books={this.state.books}></Books>*/}
                <Router>
                    <Header></Header>
                    <main>
                        <div className={"container"}>
                            <Routes>
                                <Route path={"/books"} exact element={<Books books={this.state.books} onDelete={this.deleteBook}/>}></Route>
                                {/*<Route path={"/books/add"} exact element={() => <BookAdd/>}/>*/}
                                <Route path={"/books/add"} exact element={<BookAdd books={this.state.books}
                                                                                   authors={this.state.authors}
                                                                                   categories={this.state.categories}
                                                                                   onAddBook={this.addBook}/>}/>
                                <Route path={"/authors"} exact element={<Authors authors={this.state.authors}/>}></Route>
                                <Route path={"/countries"} exact element={<Countries countries={this.state.countries}/>}></Route>
                                <Route path={"/categories"} exact element={<Categories categories={this.state.categories}/>}></Route>
                            </Routes>
                        </div>
                    </main>
                </Router>
            </div>
        );
    }

    loadAuthors = () => {
        BooksService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }

    loadCategories = () => {
        BooksService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadCountries = () => {
        BooksService.fetchCountries()
            .then((data) =>{
                this.setState({
                    countries: data.data
                })
            });
    }

    loadBooks = () => {
        BooksService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    deleteBook = (id) => {
        BooksService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    addBook = (name, category, author, availableCopies, rentalStatus, condition) => {
        BooksService.addBook(name, category, author, availableCopies, rentalStatus, condition)
            .then(() => {
                this.loadBooks();
            });
    }

}

export default App;
