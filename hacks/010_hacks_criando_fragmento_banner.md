## Hacks - Criando um Fragmento Banner

### HTML
```html
<div class="dynamic-banner">
  <div class="banner-slide active"> 
    <div class="banner-content">
      <h2>Promoção Especial</h2>
      <p>Descontos exclusivos por tempo limitado.</p>
      <a href="#" class="cta-button">Saiba Mais</a>
    </div>
  </div>
  <div class="banner-slide">
    <div class="banner-content">
      <h2>Novidades de Produto</h2>
      <p>Explore nossa nova linha de produtos.</p>
      <a href="#" class="cta-button">Ver Produtos</a>
    </div>
  </div>
  <div class="banner-slide">
    <div class="banner-content">
      <h2>Evento Exclusivo</h2>
      <p>Participe do nosso próximo evento virtual.</p>
      <a href="#" class="cta-button">Inscreva-se</a>
    </div>
  </div>

    <!-- Controles para navegar pelos slides -->
  <div class="banner-controls">
    <span class="prev">&lt;</span>
    <span class="next">&gt;</span>
  </div>
</div>

```

### CSS
```css
       .dynamic-banner {
	position: relative;
	width: 100%;
	height: 400px;
	overflow: hidden;
	background-image: url("https://raw.githubusercontent.com/ambientelivre/samples-liferay/refs/heads/master/design/learn/learn-educational-free-responsive-web-template/assets/images/bg_header.jpg");	
	background-position: top;
	background-size: cover;
}
.banner-slide {
	display: none;
	position: absolute;
	width: 100%;
	height: 100%;
}
.banner-slide.active {
	display: block;
       }
.banner-content {
	position: absolute;
	bottom: 50px;
	left: 50px;
	color: #fff;
}
.banner-content h2 {
	font-size: 36px;
	margin-bottom: 10px;
}
.banner-content p {
	font-size: 18px;
	margin-bottom: 20px;
}
.cta-button {
	background-color: #B6124A;
	color: #fff;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 5px;
}
.cta-button:hover {
	background-color: #B6124A;
	text-decoration: none;
	color: #222
}
.banner-controls {
	position: absolute;
	bottom: 20px;
	right: 20px;
	display: flex;
	gap: 10px;
}
.banner-controls span {
	cursor: pointer;
	background-color: rgba(0, 0, 0, 0.5);
	color: #fff;
	padding: 10px 20px;
	border-radius: 50%;
	font-size: 18px;
}
.banner-controls span:hover {
	background-color: rgba(0, 0, 0, 0.8);
}
```

### JavaScript
```javascript
document.addEventListener("DOMContentLoaded", function () {
  let slides = document.querySelectorAll(".banner-slide");
  let currentSlide = 0;
  const nextSlide = () => {
    slides[currentSlide].classList.remove("active");
    currentSlide = (currentSlide + 1) % slides.length;
    slides[currentSlide].classList.add("active");
  };
  const prevSlide = () => {
    slides[currentSlide].classList.remove("active");
    currentSlide = (currentSlide - 1 + slides.length) % slides.length;
    slides[currentSlide].classList.add("active");
  };

  document.querySelector(".next").addEventListener("click", nextSlide);
  document.querySelector(".prev").addEventListener("click", prevSlide);
    
  // Rotação automática a cada 3 segundos
  setInterval(nextSlide, 3000);
});

```