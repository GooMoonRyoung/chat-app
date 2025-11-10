import { Routes } from '@angular/router';

// Import your new components
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';
import { ChatComponent } from './features/chat/chat.component';

export const routes: Routes = [
  // When the app loads, redirect from "" to "/login"
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  // Define the routes for your new pages
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'chat', component: ChatComponent },

  // (We'll add an auth guard to the 'chat' route on Day 9)
];
