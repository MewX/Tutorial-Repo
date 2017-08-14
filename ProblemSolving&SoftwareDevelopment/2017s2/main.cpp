#include "wzy/AddMultiply.hpp"

int main()
{
	//(new AddMultiply("0", "0", 10))->outputAnswer();
	//(new AddMultiply("0", "0", 2))->outputAnswer();
	//(new AddMultiply("101 5 10"))->outputAnswer();
	(new AddMultiply("12 98 10"))->outputAnswer();
	(new AddMultiply("123456789987654321 98765432123456789 10"))->outputAnswer();
	(new AddMultiply("9999912399999 98765432123456789 10"))->outputAnswer();
	(new AddMultiply("101010010110100010101010101001010101010100100101010111111010010101111 1111111111011111010100101010100101010101010110101010 2"))->outputAnswer();
	(new AddMultiply("1111111111011111010100101010100101010101010110101010 101010010110100010101010101001010101010100100101010111111010010101111 2"))->outputAnswer();
	//(new AddMultiply("98765432123456789 9999912399999 10"))->outputAnswer();
	//(new AddMultiply("12 98 10"))->outputAnswer();
	//(new AddMultiply("12 98 10"))->outputAnswer();
	//(new AddMultiply("42 16 10"))->outputAnswer();
	//(new AddMultiply("14712389074 512341234 10"))->outputAnswer();
	system("pause");
}
