String[] keysRow1 = {"Q","W","E","R","T","Y","U","I","O","P"};
String[] keysRow2 = {"A","S","D","F","G","H","J","K","L"};
String[] keysRow3 = {"Z","X","C","V","B","N","M"};

ArrayList<Key> keys = new ArrayList<Key>();
String typedText = "";

void setup() {
  size(800, 300);
  textSize(24);
  
  // First row
  for (int i = 0; i < keysRow1.length; i++) {
    keys.add(new Key(keysRow1[i], 50 + i*60, 50));
  }
  // Second row
  for (int i = 0; i < keysRow2.length; i++) {
    keys.add(new Key(keysRow2[i], 80 + i*60, 120));
  }
  // Third row
  for (int i = 0; i < keysRow3.length; i++) {
    keys.add(new Key(keysRow3[i], 110 + i*60, 190));
  }
}

void draw() {
  background(255);
  fill(0);
  text("Typed: " + typedText, 50, 280);
  
  for (Key k : keys) {
    k.display();
  }
}

void mousePressed() {
  for (Key k : keys) {
    if (k.isHovered(mouseX, mouseY)) {
      typedText += k.label;
    }
  }
}

class Key {
  String label;
  float x, y, w = 50, h = 50;
  
  Key(String label, float x, float y) {
    this.label = label;
    this.x = x;
    this.y = y;
  }
  
  void display() {
    stroke(0);
    fill(200);
    rect(x, y, w, h, 5);
    fill(0);
    textAlign(CENTER, CENTER);
    text(label, x + w/2, y + h/2);
  }
  
  boolean isHovered(float mx, float my) {
    return mx > x && mx < x + w && my > y && my < y + h;
  }
}
