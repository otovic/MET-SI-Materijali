#include <iostream>
#include <iomanip>
#include <cmath>

const double PI = 3.14159;

using namespace std;

class Kupa {
private:
	double r, H;
public:
	Kupa(double r, double H) {
		this->r = r;
		this->H = H;
	}
	
	double povrsina() {
		return PI * r * r * H / 3;
	}
	
	double zapremina() {
		return PI * r * (r + sqrt(r * r + H * H));
	}
};

int main()
{
	double r, H;
	cout << "Unesite poluprecnik kupe: ";
	cin >> r;
	cout << "Unesite visinu kupe: ";
	cin >> H;
	
	Kupa k(r, H);

	cout << fixed << setprecision(2);
	cout << "B = r^2 * Pi = " << r << "^2 * Pi = " << r * r << " * Pi = " << k.povrsina() << " cm2" << endl;
	cout << "M = r^2 * Pi * s = " << r << "^2 * Pi * " << k.povrsina() << " = " << k.zapremina() << " cm3" << endl;
}