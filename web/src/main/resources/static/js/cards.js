function createCard(data) {
    const container = document.createElement("div");
    container.classList.add("container");

    const card = document.createElement("div");
    card.classList.add("card", data.title.toLowerCase().replace(" ", "-"));

    const price = document.createElement("p");
    price.classList.add("price");
    price.textContent = data.price;

    const imgBx = document.createElement("div");
    imgBx.classList.add("imgBx");

    const img = document.createElement("img");
    img.src = data.image;
    img.alt = `a pair of ${data.title} sneakers`;

    const contentBx = document.createElement("div");
    contentBx.classList.add("contentBx");

    const h2 = document.createElement("h2");
    h2.textContent = data.title;

    const sizeDiv = document.createElement("div");
    sizeDiv.classList.add("size");

    const h3 = document.createElement("h3");
    h3.textContent = "Size :";

    data.sizes.forEach(size => {
        const span = document.createElement("span");
        span.textContent = size;
        sizeDiv.appendChild(span);
    });

    const anchor = document.createElement("a");
    anchor.setAttribute("href", `/catalogue/products/${data.id}`);
    const button = document.createElement("button");
    button.textContent = "Add to Cart";
    anchor.appendChild(button);

    imgBx.appendChild(img);
    contentBx.appendChild(h2);
    contentBx.appendChild(sizeDiv);
    contentBx.appendChild(anchor);
    card.appendChild(price);
    card.appendChild(imgBx);
    card.appendChild(contentBx);
    container.appendChild(card);

    return container;
}
