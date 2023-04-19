import axios from "../custom-axios/axios";

const BooksService = {
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    fetchCategories: () => {
        return axios.get("/categories")
    },
    fetchCountries: () => {
        return axios.get("/countries")
    },
    fetchBooks: () => {
        return axios.get("books")
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },
    addBook: (name, category, author, availableCopies, rentalStatus, condition) => {
        return axios.post("books/add", {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies,
            "rentalStatus" : rentalStatus,
            "condition" : condition
        })
    }
}

export default BooksService