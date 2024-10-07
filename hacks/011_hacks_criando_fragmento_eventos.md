## Hacks - Criando um Fragmento Eventos

### HTML
```html
<div class="event-schedule">
  <h2>Agenda de Eventos</h2>
  <div class="filter">
    <label for="filter-month">Filtrar por mês:</label>
    <select id="filter-month">
      <option value="all">Todos</option>
      <option value="Set">Setembro</option>
      <option value="Out">Outubro</option>
    </select>
  </div>
  <div class="event-item">
    <div class="event-date">
      <span class="day">15</span>
      <span class="month">Set</span>
    </div>
    <div class="event-details">
      <h3>Workshop de Desenvolvimento Web</h3>
      <p>Aprenda as melhores práticas para construir aplicações web modernas.</p>
      <a href="#" class="cta-button">Detalhes</a>
    </div>
  </div>
    
  <div class="event-item">
    <div class="event-date">
      <span class="day">30</span>
      <span class="month">Set</span>
    </div>
    <div class="event-details">
      <h3>Hackathon de Inovação</h3>
      <p>Participe de uma maratona de desenvolvimento com equipes de todo o país.</p>
      <a href="#" class="cta-button">Detalhes</a>
    </div>
  </div>
    
  <div class="event-item">
    <div class="event-date">
      <span class="day">20</span>
      <span class="month">Out</span>
    </div>
    <div class="event-details">
      <h3>Workshop de Desenvolvimento Back-end</h3>
      <p>Aprenda as melhores práticas para construir aplicações back-end.</p>
      <a href="#" class="cta-button">Detalhes</a>
    </div>
  </div>
</div>
```

### CSS
```css
.event-schedule {
	width: 100%;
	max-width: 900px;
	margin: 0 auto;
	padding: 20px;
}
.event-schedule h2 {
	text-align: center;
	font-size: 36px;
	margin-bottom: 40px;
}
.filter {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-bottom: 40px;
}
.filter label {
	font-size: 18px;
	margin-right: 10px;
	color: #333;
}
.filter select {
	padding: 10px 15px;
	font-size: 16px;
	border: 1px solid #ddd;
	border-radius: 8px;
	background-color: #f4f4f4;
	color: #333;
	transition: all 0.3s ease;
}
.filter select:hover {
	background-color: #e9e9e9;
}
.event-item {
	display: flex;
	align-items: center;
	margin-bottom: 30px;
	border: 1px solid #ddd;
	padding: 15px;
	border-radius: 8px;
}
.event-date {
	width: 100px;
	text-align: center;
	background-color: #f4f4f4;
	border-radius: 50%;
	padding: 20px;
	margin-right: 20px;
}
.event-date .day {
	font-size: 32px;
	font-weight: bold;
}
.event-date .month {
	font-size: 16px;
	text-transform: uppercase;
}
.event-details h3 {
	font-size: 24px;
	margin-bottom: 10px;
}
.event-details p {
	font-size: 16px;
	margin-bottom: 15px;
}
.cta-button {
	display: inline-block;
	padding: 10px 20px;
	background-color: #B6124A;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}
```

### JavaScript
```javascript
document.getElementById("filter-month").addEventListener("change", function () {
  const selectedMonth = this.value;
  const events = document.querySelectorAll(".event-item");
    
  events.forEach(function (event) {
    const month = event.querySelector(".event-date .month").textContent;
    if (selectedMonth === "all" || month === selectedMonth) {
      event.style.display = "flex";
    } else {
      event.style.display = "none";
    }
  });
});
```
