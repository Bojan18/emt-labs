import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import App from './components/App/App';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
    document.getElementById("root")
    //renderirame App komponentata(najglavna komponenta!!!) koe se naogja vo mestoto root
    //Sto e ReactDOM, zosto e razlicno od htmlDOM
    //Document Object Model
    //se toa so se menja u app, treba da rezultira so update na DOM i da se pretstavi
    //React znae tocno koi DOM obj se promenile, ke bidat update vo vistinskiot html DOM
    //tuka se menja nesto sitno samo
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
