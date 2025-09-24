#include <bits/stdc++.h>
#include "barang.cpp"
using namespace std;

class rumahtangga : public barang // Class rumahtangga
{
private: // Atribut
    string seri;
    int daya;
    string fitur;

public:
    // Constructor 
    rumahtangga() : barang() {}

    // Getter
    string getSeri() const { return this->seri; }
    int getDaya() const { return this->daya; }
    string getFitur() const { return this->fitur; }

    // Setter
    void setSeri(string seri) { this->seri = seri; }
    void setDaya(int daya) { this->daya = daya; }
    void setFitur(string fitur) { this->fitur = fitur; }

    // Destructor
    ~rumahtangga() {}
};