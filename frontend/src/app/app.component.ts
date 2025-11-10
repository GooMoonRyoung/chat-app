import {Component, inject, signal} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClient, } from '@angular/common/http';
import {RouterLink, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  // This component is now just a layout.
  // All the data-fetching logic is gone,
  // and will be moved into the new components later.
  title = 'Chat App';
}
