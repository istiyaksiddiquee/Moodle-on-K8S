from rest_framework import serializers 

class HelloSerialozer(serializers.ModelSerializer):
    """Serializer for notice objects"""

    class Meta:
        model = Tag
        fields = ('id', 'name')
        read_only_fields = ('id',)